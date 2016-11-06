package com.rv.hadoop.spark.adressstandardization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rv.hadoop.spark.addressstandardization.vo.Company;
import com.rv.hadoop.spark.addressstandardization.vo.GeoCodeInput;
import com.rv.hadoop.spark.addressstandardization.vo.GeoCodeResult;

/**
 * Address Standardization
 * @author rangv
 * 
 */
public final class AddressStandardization implements Serializable {
  
  private static final long serialVersionUID = -6121343169037333328L;
  private static final Logger logger = LoggerFactory.getLogger(AddressStandardization.class);

  public static void main(String[] args) throws Exception {
    SparkConf sparkConf =
        new SparkConf().setAppName("AddressStandardization").setMaster("local[*]");
    JavaSparkContext jsc = new JavaSparkContext(sparkConf);

    int quartile = 0;

    while (true) {
      quartile++;
      logger.info("Processing Quartile: " + quartile);
      ProcessAddress processAddress = new ProcessAddress(quartile);
      List<Company> companies = processAddress.buildCompanies(sparkConf, jsc);
      if (companies == null || companies.isEmpty()) break;

  	  //TODO: CALL your service here which builds the score for address verification
      GeoHandler geoHandler = new GeoHandler();
      List<GeoCodeResult> geoCodeResults = geoHandler.buildGeoCode(new ArrayList<GeoCodeInput>()); // Call your own geo builder geoHandler.buildGeoCode(inputList);

      int companyRow = 0;
      List<Company> saveList = new ArrayList<Company>();
      for (Company company : companies) {  
    	GeoCodeResult geoCodeResult = geoCodeResults.get(companyRow);
    	company.setStreet1(geoCodeResult.getStreet1());
        company.setStreet2(geoCodeResult.getStreet2());
        company.setCity(geoCodeResult.getCity());
        company.setStateprovince(geoCodeResult.getStateprovince());
        company.setCountry(geoCodeResult.getCountry());
        company.setLatitude(geoCodeResult.getLatitude());
        company.setLongitude(geoCodeResult.getLongitude());
        company.setScore(geoCodeResult.getScore());
        saveList.add(company);
        companyRow++;
      }
      processAddress.save(sparkConf, jsc, saveList);
    }
  }
}
