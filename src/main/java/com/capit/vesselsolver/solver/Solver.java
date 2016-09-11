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
        
        float val = in0d.stepCounter();
        
        
        Branch1D son = (Branch1D)in0d.getSon(); //ugly and stupid
    
        in0d.state[0][0] = val + 4 * son.getC0() ;
        in0d.state[0][1] = val - 4 * son.getC0() ;
        
    }
    
    /****
     * Rotina para o elemento de saída
     *  Uma execução por step
     * 
     * versão Martelada ---> saída supercrítica
     * 
     * @param out0d 
     */
    public static void stepOutput0D(Output0D out0d){
        
        System.arraycopy(out0d.getFather().state[0], 0, out0d.state[0], 0, 2);
        
    }
        
    /****
     * Rotina para troço 1D
     * 
     * versão Martelada ----> Estado constante
     * 
     * @param branch1d 
     */
    public static void stepBranch1D(Branch1D branch1d){
        
        
        //Do nothing for now
        
        
    }

}
