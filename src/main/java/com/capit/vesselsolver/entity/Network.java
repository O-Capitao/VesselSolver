package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.util.NetworkGenerator;
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
    
    public Map<String, AbsElement> elements;


    public Network(String name, String fileName) {
        
        this.name = name;
        this.elements = new HashMap<>();
        
        //Init the Hash Map
        {
            List<AbsElement> element_list;
            element_list = NetworkGenerator.getElementsFromFile(fileName);
            
            element_list.stream().forEach((ae) -> {
                elements.put(ae.name, ae);
            });
  
        }
        
        AbsElement.setNetwork(this);
        
        elements.entrySet().stream().forEach((entry) -> {
            entry.getValue().linkUp(this);
        });
        
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
    
    @Override
    public String toString(){
        String out = "NETWORK\nName= " + this.name;
        
        out = elements.entrySet().stream().map((entry) 
                -> entry.getValue().toString()).reduce(out, String::concat);
        
        return out;
    }
    
}
