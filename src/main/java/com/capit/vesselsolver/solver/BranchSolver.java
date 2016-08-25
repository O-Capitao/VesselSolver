package com.capit.vesselsolver.solver;

import com.capit.vesselsolver.entity.AbsElement;
import java.util.Arrays;

/**
 *
 * @author capitaoF
 */
public class BranchSolver extends Solver{

    
    float deltax; //this only works for 1D
    
    public BranchSolver(AbsElement caller, float dt, float dx) {
        
        super(caller, dt);
        deltax=dx;
        
    }

    /***
     * A design decision - 
     * Calculate lambdas for evry step (u=f(w1,w2) and c=f(u,W1))
     * vs
     * Store them in Element Object. - Branch1D
    */
    @Override
    public void solveStep() {
        
        float[][] old = owner.getState();
        float[] input = owner.getFather().getState()[ owner.getFather().getState().length ];
        float[] output = owner.getSon().getState()[0];
        
        float[][] updated = Arrays.copyOf(old, old.length); //is it fast?        
        
        for (int i = 0 ; i < old.length ; i++ ){
            
            updated[i][0] = old[i][0] - deltat*deltax;
            
        }
        
    }
    
}
