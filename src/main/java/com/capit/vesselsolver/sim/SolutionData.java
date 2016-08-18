package com.capit.vesselsolver.sim;

import java.util.ArrayList;
import java.util.List;

/**
 *Stores/ Handles Output of Solver
 * 
 * 
 *  parto do principio que dim=2
 * 
 *      vector sol: {p,u} --> {W1,W2}
 * 
 * @author capitaoF
 */
public class SolutionData {
    
    Simulation sim;
    
    List<float[]> solution;
    
    
    
    public SolutionData(Simulation sim){
        this.sim=sim;
        this.init();
    }
    
    private void init(){
        
        this.solution = new ArrayList<>();
        
    }
    
}
