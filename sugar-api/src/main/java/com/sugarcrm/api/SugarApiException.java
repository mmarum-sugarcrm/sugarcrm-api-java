package com.sugarcrm.api;

/**
 * Sugar API Exception
 * 
 * Errors from the server will have a non-zero error {@link SugarApiException#number} and {@link SugarApiException#description}
 * 
 * @author mmarum
 *
 */
public class SugarApiException extends Exception {
  
  private static final long serialVersionUID = 1L;
  
  protected int number = 0;
  protected String description = "";

  public SugarApiException(String message){
    super(message);
  }

  public SugarApiException(String message, Throwable rootCause){
    super(message, rootCause);
  }
  
  public void setNumber(int number) {
    this.number = number;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  /**
   * Error identifying number returned from server
   * Zero value indicates a wrapped exception meaning you should check {@link Exception#getCause()} for more details.
   * @return error number
   */
  public int getNumber() {
    return number;
  }
  
  public String getDescription() {
    return description;
  }

}
