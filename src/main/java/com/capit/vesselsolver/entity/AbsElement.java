package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.solver.Solver;
import com.capit.vesselsolver.util.StringUtil;

/**
 * TODO:
 * 
 * @author capitaoF
 */
public abstract class AbsElement {
    
    /***
     * Every element keeps this private reference to the network
     */
    private static Network nw;
    String id;
    int n_disc;
    String fatherName, sonName;
    public float[][] state;
    static int elementCounter;
    private AbsElement father,son;
    
    /***
     * GETTERS AND SETTERS
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getN_disc() {
        return n_disc;
    }

    public void setN_disc(int n_disc) {
        this.n_disc = n_disc;
    }

    public AbsElement getFather() {
        return father;
    }

    public void setFather(AbsElement father) {
        this.father = father;
    }

    public AbsElement getSon() {
        return son;
    }

    public void setSon(AbsElement son) {
        this.son = son;
    }

    public float[][] getState() {
        return state;
    }
    
    /**
     * Just an adapter
     */
    abstract void solveStep();

    /***
     * After tree init run this to turn names into references 
     */
    public void linkUp( Network net ){
        
        son = net.elements.get(sonName);
        father = net.elements.get(fatherName);
        
    }
    
    /****
     * State is defined by :
     * 
     * {W1, W2 } ( C0 é fixo e propriedade )
     */
    final void initState(){
        
        state = new float[n_disc][2];
        
        for (float[] out : state){
            for (float inn : out ){
                inn = 0 ;
            }
        }
        
    }

    /***
     * 
     */
    public AbsElement(String name){
        this.id = name ;
    }
    
    public void setState(float[][] state) {
        this.state = state;
    }
    
    
    @Override
    public String toString(){
        
        return "\n\nELEMENT\nElement Name: " + this.getId()+
                    "\nFather= " + fatherName + 
                    "\nSon= " + sonName;
    }
   
    /*****
     * Fixes the input network as the one to which every Element
     * created by the program belongs
     * @param net - Network Object
     */
    public static void setNetwork(Network net){
        nw =net;
    }
    
    public String stateToJSONText(){
        
        String output = "[";
        
        for (int i = 0 ; i < this.n_disc ; i++ ){
            
            output += "[" + state[i][0] + StringUtil.delimiter + state[i][1] + "]";
            
            if ( i <= (n_disc-1) ){
                
                output += StringUtil.delimiter;
                
            }
        }
      
        return output+"]";
    }
    
}
