package com.capit.vesselsolver.solver;

import com.capit.vesselsolver.entity.AbsElement;
import com.capit.vesselsolver.entity.Branch1D;

/**
 *
 *  SOlver 
 * 
 * @author capitaoF
 */
public abstract class Solver {
    
    AbsElement owner;
    
    float deltat;
    
    public Solver(AbsElement caller, float dt){
        caller.setSolver(this);
        
        deltat = dt;
        
        
    }
    
 
    public abstract void solveStep();
        

}
