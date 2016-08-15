package com.capit.vesselsolver.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author capitaoF
 */
public class VesselTree {
    
    List<Vessel> vessels;
    String treeName;
    
    private void init(int size){
        vessels=new ArrayList<>(size);
    }
    
    public VesselTree(){
        
    }
    
    
    private void saveTreeToFile(){
        
    }
    
    private static VesselTree fromFile(String filename){
        return new VesselTree();
    }
    
}
