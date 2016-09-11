package com.capit.vesselsolver.entity;

import com.capit.vesselsolver.solver.Solver;

/**
 *
 * @author capitaoF
 */
public class Branch1D extends AbsElement{
    
    float dx, L, E, r, h, poiss, C0, beta, A0;
    
    public Branch1D( String name, int n_disc, String father, String son, 
                     float L, float E, float r, float h, float poiss ){
        
        super(name);
        
        this.n_disc = n_disc;
        this.fatherName=father;
        this.sonName=son;
        this.L=L;
        this.E = E;
        this.h = h;
        this.r = r;
        this.poiss = poiss;
        
        dx = L/n_disc;
        
        initState();
        
        branch1DInit();
        
    }
    
    public float getDeltaX(){
        
        return dx;
        
    }
    
    @Override
    public String toString(){
        
        return super.toString() + "\nObj. Class = " + Branch1D.class +
                "\n dx= " + this.dx +
                "\n L= " + this.L +
                "\n E= " + this.E +
                "\n r= " + this.r +
                "\n C0= " + this.C0;
        
    }

    @Override
    void solveStep() {

        Solver.stepBranch1D(this);

    }
    
    /***
     * Função de init do ramo
     *  Deriva propriedades secundárias
     *  Enche estado de info de repouso
     */
    private void branch1DInit(){
        
        //calculate derivate properties
        A0 = (float) (Math.PI * Math.pow(r,2));
        beta = (float) ((Math.pow(Math.PI,0.5)*h*E)/(.75* A0));
        C0 = (float) (Math.pow(beta/2000, 0.5) * Math.pow(A0, 0.25));
        
        //Fill up state with static information
        for (float[] out : state){
            
            out[0] = 4 * C0 ;
            out[1] = - out[0] ;
            
            
        }
        
        //Should also try to figure out max deltaX allowed
        
    }

    public float getDx() {
        return dx;
    }

    public float getC0() {
        return C0;
    }

    public float getA0() {
        return A0;
    }
    
    /***
     * Used in Network Construction And Debugging.
     * 
     * @param b1d
     * @return Estimated maximum timestep allowed
     */
    public static float getMaximumDT(Branch1D b1d){
        
        return b1d.dx / b1d.C0 ;
        
    }
    
}
