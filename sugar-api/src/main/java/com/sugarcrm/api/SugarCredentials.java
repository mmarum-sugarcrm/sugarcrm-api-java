package com.sugarcrm.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * Sugar Credentials
 * 
 * @author mmarum
 *
 */
public class SugarCredentials {

	private String user_name;
	private String password;
	
	public SugarCredentials() throws SugarApiException{
		this(null, null);
	}
	
	public SugarCredentials(String userId, String plaintextPassword) throws SugarApiException{
	  this.user_name = userId;
	  if(plaintextPassword != null){
	    setPassword(plaintextPassword);
	  }
	}
	
	public void setPassword(String plaintextPassword) throws SugarApiException{
	  try {
	    this.password = Hex.encodeHexString(MessageDigest.getInstance("MD5").digest(plaintextPassword.getBytes()));
	  }catch(NoSuchAlgorithmException ex){
	    SugarApiException sae = new SugarApiException("Unable to generate Sugar password value because this JRE does not support MD5", ex);
	    throw sae;
	  }
	}

	public String getUserName(){
		return user_name;
	}
	
	public String getEncodedPassword(){
		return password;
	}
	

}
