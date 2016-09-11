package com.capit.vesselsolver.sim;

import com.capit.vesselsolver.entity.AbsElement;
import com.capit.vesselsolver.entity.Network;
import com.capit.vesselsolver.util.FileUtil;
import com.capit.vesselsolver.util.StringUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *Stores/ Handles Output of Solver
 * 
 * 
 *  parto do principio que dim=2
 * 
 *       {W1,W2} +-- output da simulação
 * 
 * @author capitaoF
 */
public class SimulationData {
    
    Simulation sim;
    Network nw;
                                         //CADA ESTADO ---> UMA MATRIZ (n*2)
    Map<String,List<float[][]>> buff;  //reduzo a dimensão do vector porque 
                                    //eu sei n_disc.
    
    int buff_size;
    int write_counter;
    
    String dirpath, filename;
    
    
    public SimulationData(Simulation sim, int buff_size, int write_counter,
                    String path ){
        
        this.sim = sim;
        this.nw = sim.getNw();
        this.buff_size = buff_size;
        this.write_counter = write_counter;
        
        this.dirpath = path;
        
        
        
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
        
        filename = FileUtil.initFile(dirpath); //creates new random named file
        
        beginFile();
        finalizeFile();
        
    }
    
    /***
     * Network state to buffer data.
     */
    public void writeToBuff(){
        
        for (Map.Entry<String,AbsElement> entry : nw.elements.entrySet()){
            
            buff.get(entry.getKey()).add(entry.getValue().state);
            
        }
    }
    
    /**
     * Buffer data to JSON file
     */
    private void writeToFile(){
        
        FileUtil.appendStringToFile(buffertoJSONText(),
                dirpath);
            
    }
    
    
    
    
    
    /****
     * Should/Could substitute with bin file
     */
    private void beginFile() {
        
        String init_string = StringUtil.jsonify("simulationData:") +":" + "{" ;
        init_string += buffertoJSONText();
        
        FileUtil.appendStringToFile(init_string, dirpath + filename );
    
    }
    
 
    //Run this to finaliza file storing process
    private void finalizeFile(){
        
        FileUtil.appendStringToFile("}", dirpath + filename );
            
    }
    
    @Override
    public String toString(){
        
        return "{"+ StringUtil.jsonify("filename")+ ":" + StringUtil.jsonify(dirpath) + StringUtil.delimiter +
                   StringUtil.jsonify("write_counter")+ ":" + write_counter + StringUtil.delimiter +
                   StringUtil.jsonify("buff_size")+ ":" + buff_size +
               "}";
       
    }
    
    /****
     * This is the format in which each slice will be written:
     * {slice: ---> talvez desnecessário....
     * 
     *  Cada ponto   : {
     *                 a1,
     *                 a2 
     *                  }
     * 
     * 
     * 
     * 
     * 
     *  {
     *      id:"VessselName",
     *      states:[ [1,1] ,[1,1], [2,3], [4,4],
     *                +---output El.tS()------+  
     *               [1,1], [1,1], [2,3], [4,4],   | buff_size
     *               [0,0], [8,8], [9,9], [1,1] ]} |
     * 
     *    {           +------Element.n_disc---+
     * 
     *          Segue tudo de seguida, fica para o parser 
     *          o trabalho de dimensionar a matriz (n_disc, buff_size)
     * 
     * @return JSON Stringification to write to file
     */
    private String buffertoJSONText(){
        
        String output="{";
        
        for (Map.Entry<String, List<float[][]>> el : this.buff.entrySet() ){
            
            output+="{";
            output+= StringUtil.jsonify("id") + ":" + StringUtil.jsonify( el.getKey() ) + StringUtil.delimiter +
                     StringUtil.jsonify("states") + ":[";
            
            
            for (float[][] state : el.getValue() ){
                
                for (int i=0 ; i < state.length ; i++ ){
                    
                    output+="[" + state[i][0] + "," + state[i][1] + "]";
                    
                    if (i<state.length-1){
                        
                        output+=StringUtil.delimiter;
                        
                    }
                    
                }
                
            }
            
            output += "}";
        }
        
        output += "}";
        
        return output;
    }
    
    
    
    
}
