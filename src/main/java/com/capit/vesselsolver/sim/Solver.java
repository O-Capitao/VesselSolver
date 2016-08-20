package com.capit.vesselsolver.sim;

import com.capit.vesselsolver.entity.AbsElement;

/**
 *
 *  SOlver 
 * 
 * @author capitaoF
 */
public abstract class Solver {
    
    AbsElement owner;
    
    public Solver(AbsElement caller){
        caller.setSolver(this);
    }
    
 
    public void step(){
        
    }
}
