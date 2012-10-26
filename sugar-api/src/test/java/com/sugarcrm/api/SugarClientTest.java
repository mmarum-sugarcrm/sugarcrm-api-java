package com.sugarcrm.api;

import com.sugarcrm.api.v4.impl.UsersResponse;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for Sugar Client
 */
public class SugarClientTest extends TestCase {
  /**
   * Create the test case
   * 
   * @param testName
   *          name of the test case
   */
  public SugarClientTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(SugarClientTest.class);
  }

  /**
   * Rigorous Test :-)
   */
  public void testLogin() {
    SugarClient client = new SugarClient("https://demo.sugarondemand.com/mmarum_vert/seed1/jiveworld");
    try {
      SugarSession session = client.getSugarSession("Ethan", "Sugar1");
      assertNotNull(session);
      assertNotNull(session.getSessionID());
      User user = session.getUser();
      assertNotNull(user);
      assertEquals(user.getUserName(),"Ethan");
      assertEquals(user.getUserId(), "bc2879c5-1e7c-d4de-7664-4ee2a42f0a58");
      assertEquals(user.getModuleName(), "Users");
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  public void testGetBean(){
    SugarClient client = new SugarClient("https://demo.sugarondemand.com/mmarum_vert/seed1/jiveworld");
    try{
      SugarSession session = client.getSugarSession(new SugarCredentials("Ethan", "Sugar1"));
      SugarBean bean = client.getBean(session, "Opportunities", "3D24053f7c-abb8-4245-405d-4f2b1f71e1f0", com.sugarcrm.api.v4.impl.SugarBean.class);
      assertEquals(bean.getModuleName(),"Opportunities");
      
    }catch(Exception e){
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  
}
