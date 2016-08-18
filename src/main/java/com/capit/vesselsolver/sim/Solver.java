package com.capit.vesselsolver.sim;

import com.capit.vesselsolver.entity.Element;

/**
 *
 *  SOlver 
 * 
 * @author capitaoF
 */
public abstract class Solver {
    
    Element owner;
    
    public Solver(Element caller){
        caller.setSolver(this);
    }
    
 
    public void step(){
        
    }
}
