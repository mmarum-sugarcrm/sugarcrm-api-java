package com.sugarcrm.api.v4.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sugarcrm.api.SugarApiException;
import com.sugarcrm.api.SugarBean;
import com.sugarcrm.api.SugarCredentials;
import com.sugarcrm.api.SugarSession;

/**
 * Sugar API v4 specific stuff
 * 
 * @author mmarum
 *
 */
public class SugarApi {
  
  private String REST_ENDPOINT = null;
  
  private URLCodec codec = null;
  private Gson json = null;

  public SugarApi(String sugarUrl){
    REST_ENDPOINT = sugarUrl + "/service/v4/rest.php";
    json = new GsonBuilder().create();
    codec = new URLCodec();
  }
  
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
	
  public String postToSugar(String urlStr) throws Exception {
    URL url = new URL(urlStr);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.setUseCaches(false);
    conn.setAllowUserInteraction(false);
    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

    if (conn.getResponseCode() != 200) {
      throw new IOException(conn.getResponseMessage());
    }

    // Buffer the result into a string
    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      sb.append(line);
    }
    rd.close();

    conn.disconnect();
    System.out.println(sb.toString());
    return sb.toString();
  }
  
  public SugarSession getSugarSession(SugarCredentials credentials) throws SugarApiException {
    

    SugarLoginRequest loginReq = new SugarLoginRequest();
    loginReq.setUserAuth(credentials);

    SugarLoginResponse jResp = null;
    try {
      String response = postToSugar(REST_ENDPOINT+"?method=login&response_type=JSON&input_type=JSON&rest_data="+codec.encode(json.toJson(loginReq)));
      jResp = json.fromJson(response, SugarLoginResponse.class);
    } catch (Exception e) {
      e.printStackTrace();
      throw new SugarApiException("Sugar Login failed", e);
    }
    return jResp;
  }
  
  public SugarBean getBean(SugarSession session, String moduleName, String guid, SugarBean type) throws SugarApiException{
    Gson json = new GsonBuilder().create();
    String sessionId = session.getSessionID();
    String data = "{\"session\":\""+sessionId+"\",\"module_name\":\""+moduleName+"\",\"id\":\""+guid+"\"}";
    String response = null;
    try {
      response = postToSugar(REST_ENDPOINT+"?method=get_entry&response_type=JSON&input_type=JSON&rest_data="+codec.encode(json.toJson(data)));
    } catch (EncoderException e) {
      e.printStackTrace();
      throw new SugarApiException("Could not fetch bean.", e);
    } catch (Exception e) {
      e.printStackTrace();
      throw new SugarApiException("Could not fetch bean.", e);
    }
    if(type == null){
      return json.fromJson(response, SugarBean.class);
    } else {
      return json.fromJson(response, type.getClass());
    }
  }
	
	
}
