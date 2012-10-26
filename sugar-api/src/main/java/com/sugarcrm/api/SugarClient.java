package com.sugarcrm.api;

import com.sugarcrm.api.v4.impl.SugarApi;


/**
 * Sugar Client
 * 
 * @author mmarum
 *
 */
public class SugarClient 
{
  
  private SugarApi sugar = null;
  
  public SugarClient(String sugarUrl){
    //Only support 1 version of the API right now
    sugar = new SugarApi(sugarUrl);
  }
    
  public SugarSession getSugarSession(String userId, String password) throws SugarApiException{
    return sugar.getSugarSession(new SugarCredentials(userId, password));
  }
  
  public SugarSession getSugarSession(SugarCredentials credentials) throws SugarApiException{
    return sugar.getSugarSession(credentials);
  }
  
  public SugarBean getBean(SugarSession session, String moduleName, String guid, SugarBean type) throws SugarApiException{
    return sugar.getBean(session, moduleName, guid, type);
  }
  
  public SugarBean getBean(SugarSession session, String moduleName, String guid, Class<? extends SugarBean> clazz) throws SugarApiException{
    try {
      return sugar.getBean(session, moduleName, guid, clazz.newInstance());
    } catch (InstantiationException e) {
      e.printStackTrace();
      throw new SugarApiException("Could not instantiate SugarBean class", e);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      throw new SugarApiException("Could not instantiate SugarBean class", e);
    }
  }
    
  	
}
