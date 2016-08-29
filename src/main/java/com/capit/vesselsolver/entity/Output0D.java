package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.solver.Solver;

/**
 *  Purely Reflective Output
 * @author capitaoF
 */
public class Output0D extends AbsElement{
    
    float R;
    
    public Output0D( String name, String father, float R ) {
        
        super(name);
        this.n_disc = 1; //one single position
        this.state = new float[2][n_disc];
        
        this.fatherName = father;
        this.sonName = null;
        
        this.R=R;
        
    }
    
    
    @Override
    public String toString(){
        return super.toString() +"\nObj. Class: " + Output0D.class + 
                "\nRef. Coef.= " + R; 
    }

    @Override
    void solveStep() {

        Solver.stepOutput0D(this);

    }
    
    
    
    
}
