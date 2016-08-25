/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capit.vesselsolver.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author capitaof
 */
public class NetworkTest {
    
    public NetworkTest() {
    }

    @Test
    public void testNetwork() {
       
        Network nw = new Network("test_network", "/home/capitaof/NetBeansProjects/VesselSolver/input_files/SingleVesselCase.xml");
        
        System.out.println(nw.toString());
        
        if (nw.elements.get("primeiro").getFather() == null ){
            
            fail("Network not linked up....");
            
        }
        
        
    }
    
}
