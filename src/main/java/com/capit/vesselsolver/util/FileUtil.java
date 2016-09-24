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
 *
 * @author capitaoF
 */
public class FileUtil {
    
    public static String filename= null;
    public static String filepath= null;
    
    public static String initFile(String filepath){
        
        if ( FileUtil.filepath == null ){
            
            FileUtil.filepath = filepath;
            
        }
        
        try {
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            
            
            filename = "solutiondata" + sdf.format(cal.getTime());
            
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
     
     */
    public static void appendStringToFile(String str){
        
        FileWriter fw = null;
        try {
            
            File file = new File(filepath + filename);
            
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
