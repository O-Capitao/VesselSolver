package com.capit.vesselsolver.sim;

import com.capit.vesselsolver.entity.AbsElement;
import com.capit.vesselsolver.entity.Network;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *Stores/ Handles Output of Solver
 * 
 * 
 *  parto do principio que dim=3
 * 
 *      vector sol: {p,u} --> {W1,W2,u}
 * 
 * @author capitaoF
 */
public class SolutionData {
    
    Simulation sim;
    Network nw;
    
    Map<String,List<float[][]>> buff;
    
    int buff_size;
    int write_counter;
    
    String filename; //fileOutput
    File file;
    
    public SolutionData(Simulation sim, int buff_size, int write_counter,
                    String filename ){
        
        this.sim = sim;
        this.nw = sim.getNw();
        this.buff_size = buff_size;
        this.write_counter = write_counter;
        
        this.init();
        
    }
    
    /***
     * Inits the HashMap and Lists of States for Each Element
     */
    private void init(){
        
        buff = new HashMap<>();
        
        for (Map.Entry<String,AbsElement> entry : nw.elements.entrySet()){
            
            buff.put(entry.getKey(), new LinkedList<>() );
            
        }
        
        
        
        writeToBuff();
        
    }
    
    public void writeToBuff(){
        
        for (Map.Entry<String,AbsElement> entry : nw.elements.entrySet()){
            
            buff.get(entry.getKey()).add(entry.getValue().state);
            
        }
    }
    
    private void writeToFile(){
        
        
        
    }
    
    /****
     * Should substitute with bin file
     */
    private void initFile(){
        PrintWriter writer = null;
        
        try {
            file = new File(filename);
            //safety blah blah
            writer = new PrintWriter(filename, "UTF-8");
            
            
            for( Map.Entry<String, List<float[][]>> entry : buff.entrySet() ){
                
                writer.print("\nSolution for " + entry.getKey() + "\n");
                
                for( float[][] fl : entry.getValue() ){
                    ///ALL WRONG
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SolutionData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SolutionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }
    
    @Override
    public String toString(){
        
        return "\n##################################################################\n              SolutionData"
                + "\n             fileame= " +filename
                + "\n             write_counter= " + write_counter
                + "\n             buff_size= " + buff_size;
        
    }
    
}
