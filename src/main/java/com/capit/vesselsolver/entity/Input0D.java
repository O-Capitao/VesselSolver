package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.solver.Solver;
import com.capit.vesselsolver.util.StringUtil;
import org.apache.log4j.Logger;

/**
 *
 * @author capitaoF
 */
public class Input0D extends AbsElement {
    
    final int n_samples; //samples representing one full period
    int sample_counter;
    
    float amplitude, T; //amplitude <-- velocity
    
    public float[] inputValues;  //must be public to be accessable by solver
    
    public Input0D(String name, String son, float amplitude, float period ){
        
        super(name);
        
        this.amplitude = amplitude;
        this.T = period;
        
        n_samples = 100; //must init ---> dependant on dt...
        
        this.n_disc = 1; //one single position
        this.inputValues = new float[n_samples];
        
        this.fatherName=null;
        this.sonName = son;
        
        
        this.initState();
        
        
        /***
         * Assign forced input values --- imposed velocity
         */
        inputValues = sinGenerator(n_samples, amplitude);
        
        Logger.getLogger(Input0D.class).debug("Input0D init Completed.");
        
        for (float val : inputValues){
            Logger.getLogger(Input0D.class).debug(val + " ");
        }
        
    }
    
    /**
     * Produces Sin Pulse Signal ---> One half-period
     * @param n_steps number of time steps in which the period will be divided
     * 
     * amplitude=1
     * 
     * @return array of values
     * 
     */
    public static float[] sinGenerator(int n_steps, float amp ){
        
        float[] values = new float[n_steps];
        
        for (int i = 0 ; i < n_steps ; i++ ){
            
            values[i] = amp * (float) Math.sin(i*Math.PI/n_steps);
            
        }
        
        return values;
    }
    
    @Override
    public String toString(){
        
        return "{" + StringUtil.jsonify("baseObjProps") + ":" + super.toString() + StringUtil.delimiter + 
                     StringUtil.jsonify("T") + ":" + T + StringUtil.delimiter +
                     StringUtil.jsonify("amplitude") + ":" + amplitude + StringUtil.delimiter +
                     StringUtil.jsonify("n_samples") + ":" + n_samples + StringUtil.delimiter+ "}";
    }

    @Override
    void solveStep() {

        Solver.stepInput0D(this);


    }

    /***
     * For control over input values.
     *  increments counter
     * @return Value of U for present step 
     */
    public float stepCounter(){
        
        if ( sample_counter < n_samples - 1 ){
            
            return inputValues[++sample_counter];  
            
        }else{
            return inputValues[0];
        }

    }
    
}
