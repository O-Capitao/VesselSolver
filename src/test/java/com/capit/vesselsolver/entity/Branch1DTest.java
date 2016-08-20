package com.capit.vesselsolver.entity;

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
public class Branch1DTest {
    
    public Branch1DTest() {
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

    @org.junit.Test
    public void testSomeMethod() {
        
        Branch1D b1D = new Branch1D("pri",10,"s","t");
        
        if (b1D.state[0].length != 2){
            
            System.out.println(b1D.state[0].length);
            fail("Improper Vessel Dimension Number");
        }else if((b1D.state[0][0]!=0) || (b1D.state[0][1]!=0)){
            
            
            
            
            fail("Not initted");
        }
        
        
        
    }
    
}
