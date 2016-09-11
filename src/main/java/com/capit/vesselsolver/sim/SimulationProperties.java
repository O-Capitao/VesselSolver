package com.capit.vesselsolver.sim;

import com.capit.vesselsolver.entity.AbsElement;
import com.capit.vesselsolver.entity.Branch1D;
import com.capit.vesselsolver.entity.Network;
import com.capit.vesselsolver.util.StringUtil;
import java.util.Map;

/**
 * Simple container to hold Simulation Properties
 * @author capitaof
 */
public class SimulationProperties {
    
    public final float totalt;
    public final float courant;
    public float dt;
    
    
    public SimulationProperties(float time, float courant){
        this.totalt = time;
        this.courant = courant;
        
        // do not init dt for now
    }
    
    public void initDt(Simulation owner){
        dt = determineDeltaTForNetwork(owner.getNw());
    }
    
    /****
     * Courant Criterium Applicator.
     * Runs throgh every 1D vessel, and calculates delta_t as
     * 
     * @param nw
     * @return 
     */
    public static float determineDeltaTForNetwork(Network nw){
        
        float winner = 10; //start stupid
        float contender;
        
        for (Map.Entry<String,AbsElement> ele : nw.elements.entrySet()){
            
            if (ele.getValue().getN_disc()>1){
                
                //for 1D elements
                contender = Branch1D.getMaximumDT((Branch1D)ele.getValue());
                
                if (contender < winner ){
                    winner = contender;
                }
            }
        } 
        return winner;
    }
    
    
    @Override
    public String toString(){
        
        return "{" + StringUtil.jsonify("totalt") + ":" + totalt + StringUtil.delimiter +
                StringUtil.jsonify("courant")+ ":" + courant + StringUtil.delimiter + 
                StringUtil.jsonify("dt") + ":" + dt + "}";
        

    }
    
}
