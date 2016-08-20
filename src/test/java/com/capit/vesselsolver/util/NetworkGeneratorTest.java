package com.capit.vesselsolver.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author capitaoF
 */
public class NetworkGeneratorTest {
    
    public NetworkGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFromFile method, of class NetworkGenerator.
     */
    @Test
    public void testGetFromFile() {
        System.out.println("getFromFile");

        String fileLocation = "/Users/capitaoF/RepoWork/VesselSolver/input_files/SingleVesselCase.xml";

        NetworkGenerator.getFromFile(fileLocation);

    }
    
}
