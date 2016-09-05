package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.solver.Solver;

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
    String name;
    int n_disc;
    String fatherName, sonName;
    public float[][] state;
    static int elementCounter;
    private AbsElement father,son;
    
    /***
     * GETTERS AND SETTERS
     */
    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = id;
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
     * {W1, W2, u } ( C0 é fixo e propriedade )
     */
    final void initState(){
        
        state = new float[n_disc][3];
        
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
        this.name = name ;
    }
    
    public void setState(float[][] state) {
        this.state = state;
    }
    
    
    @Override
    public String toString(){
        
        return "\n\nELEMENT\nElement Name: " + this.getName()+
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
    
    
}
