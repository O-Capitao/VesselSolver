package com.capit.vesselsolver.sim;

/**
 * Simple container to hold Simulation Properties
 * @author capitaof
 */
public class SimulationProperties {
    
    public final float totalTime;
    public final float courantNumber;
    
    public SimulationProperties(float time, float courant){
        this.totalTime = time;
        this.courantNumber = courant;
    }
    
}
