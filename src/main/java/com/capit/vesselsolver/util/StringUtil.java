package com.capit.vesselsolver.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static String initFile(String filepath){
        
        try {
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            
            
            String filename = "solutiondata" + sdf.format(cal.getTime());
            
            File file = new File(filepath + filename);
            
            file.createNewFile();
            
            return filename;
            
        } catch (IOException ex) {
            
            Logger.getLogger(StringUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    }
    
    /**
     * 
     * @param str String to write
     * @param filename Full path to output file
     */
    public static void appendStringToFile(String str, String filename){
        
        FileWriter fw = null;
        try {
            
            File file = new File(filename);
            
            
            if (!file.exists()) {
               
                 file.createNewFile();
                
            }   
            
            fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.append(str);
            bw.close(); //also flushes
            
            
        } catch (IOException ex) {
            
            Logger.getLogger(StringUtil.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                
                fw.close();
                
            } catch (IOException ex) {
                
                Logger.getLogger(StringUtil.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        
    }
    
}
