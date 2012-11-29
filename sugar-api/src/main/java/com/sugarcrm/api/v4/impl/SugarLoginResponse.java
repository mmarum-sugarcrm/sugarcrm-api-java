package com.sugarcrm.api.v4.impl;

import com.sugarcrm.api.SugarSession;
import com.sugarcrm.api.User;

/**
 * Sugar login API response in v4
 * 
 * @author mmarum
 *
 */
public class SugarLoginResponse extends SugarBean implements SugarSession{
  
  public String getSessionID() {
    return id;
  }
  
  public User getUser() {
    User user = new UsersResponse(values, moduleName);
    return user;
  }

}
