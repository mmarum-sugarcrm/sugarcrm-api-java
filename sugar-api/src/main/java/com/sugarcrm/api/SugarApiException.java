package com.sugarcrm.api;

public class SugarApiException extends Exception {
  
  private static final long serialVersionUID = 1L;

  public SugarApiException(String message){
    super(message);
  }

  public SugarApiException(String message, Throwable rootCause){
    super(message, rootCause);
  }

}
