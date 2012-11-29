package com.sugarcrm.api.v4.impl;

import java.util.Collection;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

/**
 * SugarBean response for the v4 API
 * 
 * @author mmarum
 *
 */
public class SugarBean implements com.sugarcrm.api.SugarBean{
  
  @SerializedName("name_value_list")
  protected HashMap<String, HashMap<String, String>> values;
  
  @SerializedName("module_name")
  protected String moduleName;
  
  @SerializedName("id")
  protected String id;
  
  //Needed for Gson
  public SugarBean(){

  }
  
  public SugarBean(HashMap<String, HashMap<String, String>> name_value_list, String module_name) {
    values = name_value_list;
    moduleName = module_name;
  }
  
  public String getId(){
    return id;
  }

  public String get(String fieldName) {
    return values.get(fieldName).get("value");
  }

  public Collection<String> getFieldNames() {
    return values.keySet();
  }

  public String getModuleName() {
    return moduleName;
  }
  
 
}
