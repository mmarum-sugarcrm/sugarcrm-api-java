package com.sugarcrm.api.v4.impl;

import java.util.HashMap;

import com.sugarcrm.api.User;

/**
 * Users module response in v4 API
 * 
 * @author mmarum
 *
 */
public class UsersResponse extends SugarBean implements User{
  
  public UsersResponse(){
    super();
  }
  
  public UsersResponse(HashMap<String, HashMap<String, String>> values_map, String moduleName) {
    super(values_map, moduleName);
  }
  public String getUserId() {
    return values.get("user_id").get("value");
  }
  public String getUserName() {
    return values.get("user_name").get("value");
  }
  public String getUserLanguage() {
    return values.get("user_language").get("value");
  }

  
}
