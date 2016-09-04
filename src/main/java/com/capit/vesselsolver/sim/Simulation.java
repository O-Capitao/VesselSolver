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
    
    /*******
     * Default constructor and POE
     * @param name - String containing symbolic name for this Simulation
     * @param inputFile - String with full filepath to input data xml file
     */
    public Simulation(String name, String inputFile){
        
        sp = NetworkGenerator.getSimulationPropertiesFromFile(inputFile);
        nw = new Network(name, inputFile, sp);
        
        sp.initDt(this);
        
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
            System.out.println("Time: " + t );
            
        }
        
        
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
