/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package data;

import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the DataSource class.
 * @author Luke
 */
public class DataSourceTest {
    
    /**
     * Constructor for DataSourceTest.
     */
    public DataSourceTest() {
    }
    
    /**
     * Setup method executed once before all test methods.
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     * Tear down method executed once after all test methods.
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Setup method executed before each test method.
     */
    @Before
    public void setUp() {
    }
    
    /**
     * Tear down method executed after each test method.
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class DataSource.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DataSource expResult = null;
        DataSource result = DataSource.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnection method, of class DataSource.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        DataSource instance = null;
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
