package com.capit.vesselsolver.solver;

import com.capit.vesselsolver.entity.Branch1D;
import com.capit.vesselsolver.entity.Input0D;
import com.capit.vesselsolver.entity.Output0D;
import com.capit.vesselsolver.sim.Simulation;


/**
 *  Only a container for static methods
 *  @author capitaoF
 */
public abstract class Solver {
    
    static Simulation sim;
    
   
    /****
     * Rotina para o elemento de entrada na rede.
     * Gera injecção de onda sinosoidal
     * 
     *  F
     * 
     * @param in0d 
     */
    public static void stepInput0D(Input0D in0d){
        
        
        
        
    }
    
    /****
     * Rotina para o elemento de saída
     * @param out0d 
     */
    public static void stepOutput0D(Output0D out0d){
        
        
    }
        
    /****
     * Rotina para troço 1D
     * @param branch1d 
     */
    public static void stepBranch1D(Branch1D branch1d){
        
        
        
    }

}
