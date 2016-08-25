package com.capit.vesselsolver.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Handler for collection of AbsElements
 * @author capitaoF
 */
public class Network {
    
    String name;
    AbsElement root;
    
    //TODO public Map<String, AbsElement> elements;
    public List<AbsElement> elements;

    public Network(String name) {
        
        this.name = name;
        //this.elements = new HashMap<>();
        this.elements= new ArrayList<>();
        
    }
    
    public void solveNetwork(){
        
    }

    public String getName() {
        return name;
    }

    public AbsElement getRoot() {
        return root;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoot(AbsElement root) {
        this.root = root;
    }
    
    
    
}
