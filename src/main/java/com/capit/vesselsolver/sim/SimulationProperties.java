package com.capit.vesselsolver.sim;

import com.capit.vesselsolver.entity.Network;

/**
 * Simple container to hold Simulation Properties
 * @author capitaof
 */
public class SimulationProperties {
    
    public final float totalTime;
    public final float courantNumber;
    public final float delta_t;
    
    
    public SimulationProperties(float time, float courant){
        this.totalTime = time;
        this.courantNumber = courant;
        delta_t = 0;
    }
    
    /****
     * Courant Criterium Applicator.
     * Runs throgh every vesse, and calculates delta_t as
     * 
     * 
     * @param nw
     * @return 
     */
    public static float determineDeltaTForNetwork(Network nw){
        return 0;
    }
    
}
