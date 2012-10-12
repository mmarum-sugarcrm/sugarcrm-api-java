package com.sugarcrm.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SugarClient 
{
	
	private String REST_ENDPOINT = null;
    
    public SugarClient(String sugarUrl){
    	REST_ENDPOINT = sugarUrl + "/service/v4/rest.php";
    }
    
    
    public SugarSession getSugarSession(String userId, String password) throws SugarApiException{
    	return getSugarSession(new SugarCredentials(userId, password));
    }
    
    
  	public SugarSession getSugarSession(SugarCredentials credentials) throws SugarApiException {
  		Gson json = new GsonBuilder().create();
  		
  		SugarLoginRequest loginReq = new SugarLoginRequest();
  		loginReq.user_auth = credentials;
			
			SugarLoginResponse jResp = null;
			try {
				@SuppressWarnings("deprecation")
				String response = sugarHttpPost(REST_ENDPOINT+"?method=login&response_type=JSON&input_type=JSON&rest_data="+URLEncoder.encode(json.toJson(loginReq)));
				System.out.println("Sugar Login Response: " +response);
				jResp = json.fromJson(response, SugarLoginResponse.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return jResp;
  	}
  	
  	class SugarLoginRequest{
  		protected SugarCredentials user_auth;
  	}
  	
  	class NameValue{
  		protected String name;
  		protected String value;
  	}
  	
  	class SugarLoginResponse implements SugarSession{
  		protected String id;
  		//Should be 'Users'
  		protected String module_name;
  		protected UsersResponse name_value_list;
			public String getSessionID() {
				return id;
			}
  	}
  	
  	class UsersResponse{
  		protected NameValue user_id;
  		protected NameValue user_name;
  		protected NameValue user_language;
  	}

  	public String sugarHttpPost(String urlStr) throws Exception {
  		URL url = new URL(urlStr);
  		HttpURLConnection conn =
  				(HttpURLConnection) url.openConnection();
  		conn.setRequestMethod("POST");
  		conn.setDoOutput(true);
  		conn.setDoInput(true);
  		conn.setUseCaches(false);
  		conn.setAllowUserInteraction(false);
  		conn.setRequestProperty("Content-Type",
  				"application/x-www-form-urlencoded");

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
  		return sb.toString();
  	}
  	
}
