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
    
    String fatherName, sonName;
    float[][] state;
    
    static int elementCounter;

    private AbsElement father,son;
    
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
    
    
    /***
     * After tree init run this to turn names into references
     * TODO:Not sure what to pass. Network Object? Who knows every relation??
     */
    void linkUp(){
        
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
