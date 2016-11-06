package com.rv.hadoop.spark.adressstandardization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rv.hadoop.spark.addressstandardization.vo.Company;

/**
 * Process Address
 * @author rangv
 * 
 */
public final class ProcessAddress implements Serializable {

  private static final long serialVersionUID = -2476923765031033898L;

  private static final Logger logger = LoggerFactory.getLogger(ProcessAddress.class);

  private int quartile = 1;

  private static final String query =
      "select t.id, t.name, t.street1, t.street2, t.city, t.stateprovince, t.postalcode, t.country,"
          + " t.latitude, t.longitude, t.sourcekey, "
          + "t.total_employees, t.annual_revenue, t.phone_no, t.stock_symbol, "     
          + " t.web_site, t.src "
          + "from (SELECT cp.id, cp.company_name as name, cp.street1, cp.street2, cp.city, "
          + "cp.state_province as stateprovince, cp.postal_code postalcode, cp.country, cp.latitude, cp.longitude, cp.src_key as sourcekey, "
          + "cp.total_employees, cp.annual_revenue, cp.industry_code, cp.industry_code_type, cp.phone_no, cp.stock_symbol, "     
          + "cp.taxpayer_id, cp.duns_number, cp.web_site, cp.src, "
          + "NTILE(200) OVER (ORDER BY cp.src_key) AS quartile "
          + "FROM unified.company_processing as cp) t where quartile = ";

  public ProcessAddress(int quartile) {
    this.quartile = quartile;
  }


  /**
   * build geo code for addresses
   * 
   * @param geoInputList List<GeoCodeInput>
   * @return List<GeoCodeInput>
   * 
   */
  public List<Company> buildCompanies(SparkConf sparkConf, JavaSparkContext jsc) {

    logger.info("Build companies");
    HiveContext hiveCtx = new HiveContext(jsc);
    hiveCtx.setConf("spark.sql.hive.convertMetastoreOrc", "false");
    hiveCtx.setConf("hive.exec.dynamic.partition", "true");
    hiveCtx.setConf("hive.exec.dynamic.partition.mode", "nonstrict");
    DataFrame df = hiveCtx.sql(query + quartile);

    List<Company> companies = df.javaRDD().map(new Function<Row, Company>() {
      private static final long serialVersionUID = 1947679795198600997L;

      public Company call(Row row) {
        Company company = new Company();
        company.setId(row.getString(0));
        company.setName(row.getString(1));
        company.setStreet1(row.getString(2));
        company.setStreet2(row.getString(3));
        company.setCity(row.getString(4));
        company.setStateprovince(row.getString(5));
        company.setPostalcode(row.getString(6));
        company.setCountry(row.getString(7));
        company.setSourcekey(row.getString(10));
        company.setTotalEmployees(row.get(11) == null ? 0.0 : row.getDouble(11));
        company.setAnnualRevenue(row.get(12) == null ? 0.0 : row.getDouble(12));
        company.setPhoneNumber(row.getString(15));
        company.setStockSymbol(row.getString(16));
        company.setWebsite(row.getString(19));
        company.setSource(row.getString(20));
        company.setUpdateDate(new java.sql.Date(new java.util.Date().getTime()));
        company.setUpdatedBy("Address Standardization Spark Job");
        return company;
      }
    }).collect();
    return companies;
  }



  /**
   * build geo code for addresses
   * 
   * @param geoInputList List<GeoCodeInput>
   * @return List<GeoCodeInput>
   * 
   */
  public List<Company> save(SparkConf sparkConf, JavaSparkContext jsc, List<Company> companies) {

    HiveContext hiveCtx = new HiveContext(jsc);
    hiveCtx.setConf("spark.sql.hive.convertMetastoreOrc", "false");
    hiveCtx.setConf("hive.exec.dynamic.partition", "true");
    hiveCtx.setConf("hive.exec.dynamic.partition.mode", "nonstrict");
    
    String schemaString = "id, company_name, street1, street2, city, state_province, postal_code, country";
    String schemaDouble = "latitude, longitude";
    String schemaInteger = "geocode_result_score";
    String schemaString2 = "geocode_result_code, geocode_result_message";
    String schemaDouble2 = "total_employees, annual_revenue";
    String schemaString3 = "industry_code, industry_code_type, phone_no, stock_symbol, "
        + " web_site, src_key";
    String schemaDate = "dl_last_update_date";
    String schemaString4 = "dl_last_update_by";
    String schemaPartition = "src";

    // Generate the schema based on the string of schema
    List<StructField> fields = new ArrayList<StructField>();
    for (String fieldName: schemaString.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.StringType, true));
    }
    for (String fieldName: schemaDouble.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.DoubleType, true));
    }
    for (String fieldName: schemaInteger.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.IntegerType, true));
    }
    for (String fieldName: schemaString2.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.StringType, true));
    }
    for (String fieldName: schemaDouble2.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.DoubleType, true));
    }
    for (String fieldName: schemaString3.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.StringType, true));
    }
    for (String fieldName: schemaDate.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.DateType, true));
    }
    for (String fieldName: schemaString4.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.StringType, true));
    }
    for (String fieldName: schemaPartition.split(",")) {
      fields.add(DataTypes.createStructField(fieldName, DataTypes.StringType, true));
    }
    StructType schema = DataTypes.createStructType(fields);

    JavaRDD<Company> companyRDD = jsc.parallelize(companies);
    JavaRDD<Row> rowRDD = companyRDD.map(
      new Function<Company, Row>() {
        private static final long serialVersionUID = 1L;
        public Row call(Company company) throws Exception {
          return RowFactory.create(company.getId(), company.getName(), company.getStreet1(), company.getStreet2(), company.getCity(),
              company.getStateprovince(), company.getPostalcode(), company.getCountry(), company.getLatitude(), 
              company.getLongitude(), company.getScore(), company.getResultCode(), 
              company.getResultMessage(), company.getTotalEmployees(), company.getAnnualRevenue(), 
              company.getPhoneNumber(), company.getStockSymbol(),
              company.getWebsite(), company.getSourcekey(), company.getUpdateDate(), company.getUpdatedBy(), company.getSource());
        }
      });
    DataFrame companyDataFrame = hiveCtx.createDataFrame(rowRDD, schema);
    companyDataFrame.show();
    companyDataFrame.write().mode(SaveMode.Append).partitionBy("src").saveAsTable("unified.company");
    return companies;
  }
}
