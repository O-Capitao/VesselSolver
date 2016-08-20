package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.sim.Solver;

/**
 *
 * @author capitaoF
 */
public abstract class AbsElement {
    
    String id;
    int n_disc;
        
    Solver solver;
    
    AbsElement father, son;
    float[][] state;
    
    static int elementCounter;

    
    /***
     * GETTERS AND SETTERS
     * 
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

    public Solver getSolver() {
        return solver;
    }

    public void setSolver(Solver solver) {
        this.solver = solver;
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
    
    void initState(){
        
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
        id = name ;
    }
    
    
    
    /***
     * 
     */
    public void setState(float[][] state) {
        this.state = state;
    }
    
    
    
   
    
}
