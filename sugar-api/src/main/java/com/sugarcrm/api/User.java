package com.sugarcrm.api;

/**
 * Sugar User API
 * @author mmarum
 *
 */
public interface User extends SugarBean {
  
  public String getUserId();
  public String getUserName();
  public String getUserLanguage();

}
