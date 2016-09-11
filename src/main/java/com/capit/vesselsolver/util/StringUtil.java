package com.capit.vesselsolver.util;

/**
 * This one exists to make my like easier
 * 
 * @author capitaoF
 */
public class StringUtil {
    
    public static char delimiter = ',';
    
    /**
     * Tired of escaping quotes
     * @param string - Plain String
     * @return Double quoted String
     */
    public static String jsonify(String string){
        return "\""+ string + "\"";
    }
    
    
    
}
