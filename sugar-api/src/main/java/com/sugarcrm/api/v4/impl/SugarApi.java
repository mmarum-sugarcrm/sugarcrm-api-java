package com.sugarcrm.api.v4.impl;

import com.sugarcrm.api.SugarCredentials;

public class SugarApi {
	
	
	public class SugarLoginRequest{
		protected SugarCredentials user_auth;
		public void setUserAuth(SugarCredentials auth){
			user_auth = auth;
		}
	}
	
	public class NameValue{
		protected String name;
		protected String value;
	}
	
	
}
