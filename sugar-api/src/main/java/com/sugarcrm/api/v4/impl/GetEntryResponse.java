package com.sugarcrm.api.v4.impl;

import com.google.gson.annotations.SerializedName;

/**
 * GetEntry response for v4 API
 * @author mmarum
 *
 */
public class GetEntryResponse {

  @SerializedName("entry_list")
  protected SugarBean[] entryList;
  
  public SugarBean[] getEntryList() {
    return entryList;
  }
}
