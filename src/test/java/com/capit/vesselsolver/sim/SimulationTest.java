/*
 * This is õnly a test
 */
package com.capit.vesselsolver.sim;

import org.junit.Test;


/**
 *
 * @author capitaoF
 */
public class SimulationTest {
    
    @Test
    public void testRun(){
        Simulation sim = new Simulation("teste","/Users/capitaoF/RepoWork/VesselSolver/input_files/SingleVesselCase.xml");
        
        sim.solve();
  
    }

    @Test
    public void testSimulationConstruction() {
        
        Simulation sim = new Simulation("teste","/Users/capitaoF/RepoWork/VesselSolver/input_files/SingleVesselCase.xml");
        
        System.out.println(sim.toString());
        
    }
    
}
