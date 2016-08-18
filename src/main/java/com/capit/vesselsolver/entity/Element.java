package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.sim.Solver;

/**
 *
 * @author capitaoF
 */
public abstract class Element {
    
    String id;
    int n_disc;
        
    Solver solver;
    
    Element father, son;
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

    public Element getFather() {
        return father;
    }

    public void setFather(Element father) {
        this.father = father;
    }

    public Element getSon() {
        return son;
    }

    public void setSon(Element son) {
        this.son = son;
    }

    public float[][] getState() {
        return state;
    }

    /***
     * 
     */
    public Element(){
        this.id = "EL_" + Integer.toString(++Element.elementCounter);
    }
    
    
    
    /***
     * 
     */
    public void setState(float[][] state) {
        this.state = state;
    }
    
   
    
}
