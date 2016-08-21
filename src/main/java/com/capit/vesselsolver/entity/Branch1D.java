package com.capit.vesselsolver.entity;

/**
 *
 * @author capitaoF
 */
public class Branch1D extends AbsElement{
    
    float deltax, L;
    
    public Branch1D(String name, int n_disc, String father, String son){
        super(name);
        this.n_disc = n_disc;
        
        initState();
        
        this.fatherName=father;
        this.sonName=son;
        
        deltax = L/n_disc;
    }
    
    public float getDeltaX(){
        return deltax;
    }
    
}
