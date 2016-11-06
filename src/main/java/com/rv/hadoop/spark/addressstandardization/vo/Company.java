package com.rv.hadoop.spark.addressstandardization.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Company Data Object
 * @author rangv
 *
 */
public class Company implements Serializable {

  private static final long serialVersionUID = 5800288052926697385L;
  private String id;
  private String sourcekey;
  private String name;
  private String street1;
  private String street2;
  private String city;
  private String stateprovince;
  private String postalcode;
  private String country;
  private Double latitude;
  private Double longitude;
  private Integer score;
  private String resultCode;
  private String resultMessage;
  private String source;
  
  private Double totalEmployees;
  private Double annualRevenue;  
  private String phoneNumber;    
  private String stockSymbol;    
  private String website;    
  private Date updateDate; 
  private String updatedBy;   
 
  /**
   * get id
   * 
   * @return the id
   *
   */
  public String getId() {
    return id;
  }

  /**
   * set id
   * 
   * @param id the id to set
   *
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * get sourcekey
   * 
   * @return the sourcekey
   *
   */
  public String getSourcekey() {
    return sourcekey;
  }


  /**
   * set sourcekey
   * 
   * @param sourcekey the sourcekey to set
   *
   */
  public void setSourcekey(String sourcekey) {
    this.sourcekey = sourcekey;
  }

  /**
   * get name
   * 
   * @return the name
   *
   */
  public String getName() {
    return name;
  }

  /**
   * set name
   * 
   * @param name the name to set
   *
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * get street1
   * 
   * @return the street1
   *
   */
  public String getStreet1() {
    return street1;
  }

  /**
   * set street1
   * 
   * @param street1 the street1 to set
   *
   */
  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  /**
   * get street2
   * 
   * @return the street2
   *
   */
  public String getStreet2() {
    return street2;
  }

  /**
   * set street2
   * 
   * @param street2 the street2 to set
   *
   */
  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  /**
   * get city
   * 
   * @return the city
   *
   */
  public String getCity() {
    return city;
  }

  /**
   * set city
   * 
   * @param city the city to set
   *
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * get stateprovince
   * 
   * @return the stateprovince
   *
   */
  public String getStateprovince() {
    return stateprovince;
  }

  /**
   * set stateprovince
   * 
   * @param stateprovince the stateprovince to set
   *
   */
  public void setStateprovince(String stateprovince) {
    this.stateprovince = stateprovince;
  }

  /**
   * get postalcode
   * 
   * @return the postalcode
   *
   */
  public String getPostalcode() {
    return postalcode;
  }

  /**
   * set postalcode
   * 
   * @param postalcode the postalcode to set
   *
   */
  public void setPostalcode(String postalcode) {
    this.postalcode = postalcode;
  }

  /**
   * get country
   * 
   * @return the country
   *
   */
  public String getCountry() {
    return country;
  }

  /**
   * set country
   * 
   * @param country the country to set
   *
   */
  public void setCountry(String country) {
    this.country = country;
  }


  /**
   * get resultCode
   * 
   * @return the resultCode
   *
   */
  public String getResultCode() {
    return resultCode;
  }


  /**
   * set resultCode
   * 
   * @param resultCode the resultCode to set
   *
   */
  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }


  /**
   * get resultMessage
   * 
   * @return the resultMessage
   *
   */
  public String getResultMessage() {
    return resultMessage;
  }


  /**
   * set resultMessage
   * 
   * @param resultMessage the resultMessage to set
   *
   */
  public void setResultMessage(String resultMessage) {
    this.resultMessage = resultMessage;
  }

  
  /**
   * get source
   * @return the source
   *
   */
  public String getSource() {
    return source;
  }

  
  /**
   * set source
   * @param source the source to set
   *
   */
  public void setSource(String source) {
    this.source = source;
  }

  
  /**
   * get latitude
   * @return the latitude
   *
   */
  public Double getLatitude() {
    return latitude;
  }

  
  /**
   * set latitude
   * @param latitude the latitude to set
   *
   */
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  
  /**
   * get longitude
   * @return the longitude
   *
   */
  public Double getLongitude() {
    return longitude;
  }

  
  /**
   * set longitude
   * @param longitude the longitude to set
   *
   */
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  
  /**
   * get score
   * @return the score
   *
   */
  public Integer getScore() {
    return score;
  }

  
  /**
   * set score
   * @param score the score to set
   *
   */
  public void setScore(Integer score) {
    this.score = score;
  }

  
  /**
   * get totalEmployees
   * @return the totalEmployees
   *
   */
  public Double getTotalEmployees() {
    return totalEmployees;
  }

  
  /**
   * set totalEmployees
   * @param totalEmployees the totalEmployees to set
   *
   */
  public void setTotalEmployees(Double totalEmployees) {
    this.totalEmployees = totalEmployees;
  }

  /**
   * get annualRevenue
   * @return the annualRevenue
   *
   */
  public Double getAnnualRevenue() {
    return annualRevenue;
  }

  
  /**
   * set annualRevenue
   * @param annualRevenue the annualRevenue to set
   *
   */
  public void setAnnualRevenue(Double annualRevenue) {
    this.annualRevenue = annualRevenue;
  }

  
  /**
   * get phoneNumber
   * @return the phoneNumber
   *
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  
  /**
   * set phoneNumber
   * @param phoneNumber the phoneNumber to set
   *
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  
  /**
   * get stockSymbol
   * @return the stockSymbol
   *
   */
  public String getStockSymbol() {
    return stockSymbol;
  }

  
  /**
   * set stockSymbol
   * @param stockSymbol the stockSymbol to set
   *
   */
  public void setStockSymbol(String stockSymbol) {
    this.stockSymbol = stockSymbol;
  }

  
  /**
   * get website
   * @return the website
   *
   */
  public String getWebsite() {
    return website;
  }

  
  /**
   * set website
   * @param website the website to set
   *
   */
  public void setWebsite(String website) {
    this.website = website;
  }

  
  /**
   * get updateDate
   * @return the updateDate
   *
   */
  public Date getUpdateDate() {
    return updateDate;
  }

  
  /**
   * set updateDate
   * @param updateDate the updateDate to set
   *
   */
  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  
  /**
   * get updatedBy
   * @return the updatedBy
   *
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  
  /**
   * set updatedBy
   * @param updatedBy the updatedBy to set
   *
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

}
