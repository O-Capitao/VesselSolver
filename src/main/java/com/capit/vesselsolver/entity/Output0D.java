package com.capit.vesselsolver.entity;

/**
 *  Purely Reflective Output
 * @author capitaoF
 */
public class Output0D extends AbsElement{
    
    public Output0D(String name) {
        
        super(name);
        this.n_disc = 1; //one single position
        this.state = new float[2][n_disc];
        
        
    }
    
    
    
}
