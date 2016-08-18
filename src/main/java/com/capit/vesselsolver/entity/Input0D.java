package com.capit.vesselsolver.entity;

/**
 *
 * @author capitaoF
 */
public class Input0D extends Element {
    
    int n_samples;
    float amplitude, T;
    
    float[][] inputValues;
    
    
    public Input0D(Element son, float amplitude, float period, int n_samples ){
        super();
        
        this.amplitude = amplitude;
        this.T = period;
        
        this.n_samples = n_samples;
        
        this.n_disc = 1; //one single position
        
        this.state = new float[2][n_disc];
        this.inputValues = new float[2][n_samples];
        
        
        
        
    }
    
    
}
