package com.rv.hadoop.spark.addressstandardization.vo;

/**
 * Geo Code Result
 * @author rangv
 *
 */
public class GeoCodeResult {

	private String street1;
	private String street2;
	private String city;
	private String stateprovince;
	private String postalcode;
	private String country;
	private Double latitude;
	private Double longitude;
	private Integer score;


	/**
	 * get street1
	 * 
	 * @return the street1
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * set street1
	 * 
	 * @param street1
	 *            the street1 to set
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * get street2
	 * 
	 * @return the street2
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * set street2
	 * 
	 * @param street2
	 *            the street2 to set
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * get city
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * set city
	 * 
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * get stateprovince
	 * 
	 * @return the stateprovince
	 */
	public String getStateprovince() {
		return stateprovince;
	}

	/**
	 * set stateprovince
	 * 
	 * @param stateprovince
	 *            the stateprovince to set
	 */
	public void setStateprovince(String stateprovince) {
		this.stateprovince = stateprovince;
	}

	/**
	 * get postalcode
	 * 
	 * @return the postalcode
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * set postalcode
	 * 
	 * @param postalcode
	 *            the postalcode to set
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	/**
	 * get country
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * set country
	 * 
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * get latitude
	 * 
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * set latitude
	 * 
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * get longitude
	 * 
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * set longitude
	 * 
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	
	/**
	 * get score
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	
	/**
	 * set score
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

}
