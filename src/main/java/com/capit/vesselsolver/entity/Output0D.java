package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.solver.Solver;
import com.capit.vesselsolver.util.StringUtil;

/**
 *  Purely Reflective Output
 * @author capitaoF
 */
public class Output0D extends AbsElement{
    
    float R;
    
    public Output0D( String name, String father, float R ) {
        
        super(name);
        this.n_disc = 1; //one single position
        this.state = new float[3][n_disc];
        
        this.fatherName = father;
        this.sonName = null;
        
        this.R=R;
        
        initState();
        
    }
    
    
    @Override
    public String toString(){
        
        return "{" + StringUtil.jsonify("baseElementProps") + ":" + super.toString() + StringUtil.delimiter + 
             StringUtil.jsonify("R") + ":" + R +"}\n";
    }

    @Override
    void solveStep() {

        Solver.stepOutput0D(this);

    }
    
    
    
    
}
