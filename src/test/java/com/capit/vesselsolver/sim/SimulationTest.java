/*
 * This is õnly a test
 */
package com.capit.vesselsolver.sim;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 *
 * @author capitaoF
 */
public class SimulationTest {
    
    Logger logger = Logger.getLogger(this.getClass());
    
    @Test
    public void testRun(){
        
        logger.info("\n##################################################################\n              Starting SimulationTest\n             init");
        
        Simulation sim = new Simulation("teste","/Users/capitaoF/RepoWork/VesselSolver/input_files/SingleVesselCase.xml");
        
        logger.info("\n##################################################################\n              Running SimulationTest\n             solve");
        
        sim.solve();
        
        
        logger.info("\n##################################################################\n              Ending SimulationTest");
  
    }
    
    @Test
    public void testWrite(){
        
        Simulation sim = new Simulation("teste","/Users/capitaoF/RepoWork/VesselSolver/input_files/SingleVesselCase.xml");
        
        SimulationData sd = new SimulationData(sim, 3, 3,"/Users/capitaoF/RepoWork/VesselSolver/output_files/" );
        

        
    }


    
}
