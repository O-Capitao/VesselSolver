package com.capit.vesselsolver.entity;

/**
 *
 * @author capitaoF
 */
public class Input0D extends AbsElement {
    
    int n_samples;
    float amplitude, T;
    
    float[][] inputValues;
    
    
    public Input0D(String name, String son, float amplitude, float period, int n_samples ){
        
        super(name);
        
        this.amplitude = amplitude;
        this.T = period;
        this.n_samples = n_samples;
        this.n_disc = 1; //one single position
        this.inputValues = new float[2][n_samples];
        
        this.fatherName=null;
        this.sonName = son;
        
        
        this.initState();
        
        
    }
    
    /**
     * Produces Sin Pulse Signal ---> One half-period
     * @param n_steps number of time steps in which the period will be divided
     * @return array of values
     * 
     */
    public static float[] sinGenerator(int n_steps){
        
        float[] values = new float[n_steps];
        
        for (int i = 0 ; i < n_steps ; i++ ){
            
            values[i] = (float) Math.sin(i*Math.PI/n_steps);
            
        }
        
        return values;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nT=" + this.T +
                    "\namplitude=" + this.amplitude;
    }
    
    
}
