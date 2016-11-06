package com.rv.hadoop.spark.adressstandardization;

import java.io.Serializable;
import java.util.List;

import com.rv.hadoop.spark.addressstandardization.vo.GeoCodeInput;
import com.rv.hadoop.spark.addressstandardization.vo.GeoCodeResult;

/**
 * Geo Handler takes a list of addresses and constructs geo information for each address
 * @author rangv
 * 
 */
public final class GeoHandler  implements Serializable {

  private static final long serialVersionUID = -128118533678582039L;

  /**
   * build geo code for addresses
   * 
   * @param geoInputList List<GeoCodeInput>
   * @return List<GeoCodeInput>
   * 
   */
  public List<GeoCodeResult> buildGeoCode(List<GeoCodeInput> geoInputList) {
	  //TODO : replace with your service call to build geo codes
	  return null;
  }
}

