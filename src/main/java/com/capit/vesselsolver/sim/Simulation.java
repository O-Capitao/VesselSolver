package com.capit.vesselsolver.sim;

import com.capit.vesselsolver.entity.Network;
import com.capit.vesselsolver.util.NetworkGenerator;


/**
 * Widest representing class
 * @author capitaoF
 */
public class Simulation {
    
    String name;
    
    private Network nw;
    private SimulationProperties sp;
    
    /***
     * Default constructor and POE
     * @param name - String containing symbolic name for this Simulation
     * @param inputFile - String with full filepath to input data xml file
     */
    public Simulation(String name, String inputFile){
        
        sp = NetworkGenerator.getSimulationPropertiesFromFile(inputFile);
        nw = new Network(name, inputFile, sp);
        
    }
    
    private void solveStep(){
    
        
        
    }
    
    

    
    
}
