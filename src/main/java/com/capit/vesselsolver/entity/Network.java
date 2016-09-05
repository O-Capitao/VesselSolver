package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.sim.SimulationProperties;
import com.capit.vesselsolver.util.NetworkGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;



/**
 *Handler for collection of AbsElements
 * @author capitaoF
 */
public class Network implements Cloneable {
    
    String name;
    AbsElement root;
    
    
    
    public Map<String, AbsElement> elements;


    public Network(String name, String fileName, SimulationProperties sp) {
        
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
        
        //hardcoded and ugly...
        this.root = elements.get("input");
        
        AbsElement.setNetwork(this);
        
        elements.entrySet().stream().forEach((entry) -> {
            entry.getValue().linkUp(this);
        });
        
        
        Logger.getLogger(Network.class).info("\n##################################################################\n              Network has been Constructed\n"
                        + this.toString());
        
    }
    
   
    
    //TODO -> Desencadear solução do passo actual a partir do elemento root
    // Only called one time per timestep
    public void solveStep(){
        
        AbsElement worker = root;
        //for now! Only for now
        //Solve Only one Step
        
        do {            
            
            worker.solveStep();
            worker = worker.getSon();
            
        } while ( worker != null );
        
        
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
