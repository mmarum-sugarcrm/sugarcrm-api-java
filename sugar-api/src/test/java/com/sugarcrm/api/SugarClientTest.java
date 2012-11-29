package com.sugarcrm.api;

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
    SugarClient client = new SugarClient("http://sugar658-sugartest.rhcloud.com");
    try {
      SugarSession session = client.getSugarSession("admin", "admin");
      assertNotNull(session);
      assertNotNull(session.getSessionID());
      User user = session.getUser();
      assertNotNull(user);
      assertEquals(user.getUserName(),"admin");
      assertEquals(user.getUserId(), "1");
      assertEquals(user.getModuleName(), "Users");
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  public void testGetBean(){
    SugarClient client = new SugarClient("http://sugar658-sugartest.rhcloud.com");
    try{
      SugarSession session = client.getSugarSession(new SugarCredentials("admin", "admin"));
      SugarBean bean = client.getBean(session, "Opportunities", "9b4b7e72-6459-a199-25f5-50b7492a2777");
      assertEquals("Opportunities", bean.getModuleName());
      assertEquals("Prospecting", bean.get("sales_stage"));
      
    }catch(Exception e){
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }
  
  
}
