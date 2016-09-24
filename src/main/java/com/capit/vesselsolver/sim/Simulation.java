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
    
    public SimulationData sd;
    
    /*******
     * Default constructor and POE
     * @param name - String containing symbolic name for this Simulation
     * @param inputFile - String with full filepath to input data xml file
     * @param outputPath - Full path to folder with output files
     */
    public Simulation(String name, String inputFile, String outputPath){
        
        sp = NetworkGenerator.getSimulationPropertiesFromFile(inputFile);
        nw = new Network(name, inputFile, sp, this);
        
        
        sp.initDt(this);
        
        sd = new SimulationData(this, 3, 3, outputPath );
        
        
    }
    
    /***
     * Main Point of Entry For The Solver
     * Called 1 time
     */
    public void solve(){
        
        float t = 0f ; //global timecounter
    
        while (t < sp.totalt ){
            
            nw.solveStep();
            
            t+=sp.dt;
            //System.out.println("Time: " + t );
            
        }
        
        sd.exit();
        
        
    }
    
    @Override
    public String toString(){
        
        return "Simultion Name: " + name + "\nSimulation Properties: " + sp.toString() + "\n"
                + "Network Properties: " + nw.toString();
        
    }

    public Network getNw() {
        return nw;
    }

    public SimulationProperties getSp() {
        return sp;
    }
    
    

    
    
}
