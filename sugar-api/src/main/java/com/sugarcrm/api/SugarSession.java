package com.sugarcrm.api;

/**
 * Sugar Session API
 * @author mmarum
 *
 */
public interface SugarSession {
	
  public String getSessionID();
  public User getUser();

}
