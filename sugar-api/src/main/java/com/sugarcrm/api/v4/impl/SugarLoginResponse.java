package com.sugarcrm.api.v4.impl;

import com.sugarcrm.api.SugarSession;
import com.sugarcrm.api.User;

public class SugarLoginResponse extends SugarBean implements SugarSession{

  protected String id;
  protected String module_name;
  
  public String getSessionID() {
    return id;
  }
  
  public User getUser() {
    return new UsersResponse(values);
  }
}
