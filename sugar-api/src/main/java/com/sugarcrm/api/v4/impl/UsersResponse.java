package com.sugarcrm.api.v4.impl;

import java.util.HashMap;

import com.sugarcrm.api.User;

public class UsersResponse extends SugarBean implements User{
  
  public UsersResponse(HashMap<String, HashMap<String, String>> values_map) {
    super(values_map);
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
