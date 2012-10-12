package com.sugarcrm.api;

public class SugarApiException extends Exception {
	
	public SugarApiException(String message){
		super(message);
	}
	
	public SugarApiException(String message, Throwable rootCause){
		super(message, rootCause);
	}

	private static final long serialVersionUID = 1L;

}
