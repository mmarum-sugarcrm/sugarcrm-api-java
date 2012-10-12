package com.sugarcrm.api;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SugarClientTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SugarClientTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SugarClientTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
        SugarClient client = new SugarClient("https://demo.sugarondemand.com/mmarum_vert/seed1/jiveworld");
        try {
        	SugarSession session = client.getSugarSession("Ethan", "Sugar1");
					assertNotNull(session);
					assertNotNull(session.getSessionID());
				} catch (Exception e) {
					e.printStackTrace();
					fail(e.getLocalizedMessage());
				}
        
    }
}
