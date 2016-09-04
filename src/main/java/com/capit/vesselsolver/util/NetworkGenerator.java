package com.capit.vesselsolver.util;

import com.capit.vesselsolver.entity.AbsElement;
import com.capit.vesselsolver.entity.Branch1D;
import com.capit.vesselsolver.entity.Input0D;
import com.capit.vesselsolver.entity.Output0D;
import com.capit.vesselsolver.sim.SimulationProperties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *Converts data referring to network topology from the input file
 * into AbsElement objects
 * 
 * @author capitaoF
 */ 
public class NetworkGenerator {
    
    public static SimulationProperties getSimulationPropertiesFromFile(String fileLocation){
        
        SimulationProperties sp = null;
        
        try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = null;
                
            try {
                
                File fXmlFile = new File(fileLocation);

                doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();
                
            } catch (FileNotFoundException ex){
                /***
                 * In case of bad file name ----> Warn of this and exit
                 */
                
                Logger.getLogger(NetworkGenerator.class.getName()).log(Level.SEVERE, 
                        "You must provide a valid full file path, Exiting execution...", ex);
                
                System.exit(0);
                
            }
            /***
             * Properties importer
             */
            {
                NodeList inBC = doc.getElementsByTagName("simulation");
                Node inBCNode = inBC.item(0); //consider the first only
                
                sp = new SimulationProperties(
                            Float.parseFloat(inBCNode.getAttributes().getNamedItem("totaltime").getNodeValue()),
                            Float.parseFloat(inBCNode.getAttributes().getNamedItem("courant").getNodeValue())
                            );
                
            }
            

            
            
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(NetworkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (sp.totalt <= 0 ){
            
            System.out.println("Simulation duration must be a non-null positive number");
            System.exit(0);
        }
        
        return sp;
        
    }
    
    
    public static List<AbsElement> getElementsFromFile(String fileLocation){
        
        
        List<AbsElement> allElements = new ArrayList<>();
        
        
        try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = null;
                
            try {
                
                File fXmlFile = new File(fileLocation);

                doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();
                
            } catch (FileNotFoundException ex){
                /***
                 * In case of bad file name ----> Warn of this and exit
                 */
                
                Logger.getLogger(NetworkGenerator.class.getName()).log(Level.SEVERE, 
                        "You must provide a valid full file path, Exiting execution...", ex);
                
                System.exit(0);
                
            }
            /***
             * Input Aquisition
             */
            {
   
                NodeList inBC = doc.getElementsByTagName("input");
                Node inBCNode = inBC.item(0); //consider the first only
                
                Input0D in0d = new Input0D(inBCNode.getAttributes().getNamedItem("name").getNodeValue(),
                                           inBCNode.getAttributes().getNamedItem("son").getNodeValue(), 
                                           Float.parseFloat(inBCNode.getAttributes().getNamedItem("amp").getNodeValue()),
                                           Float.parseFloat(inBCNode.getAttributes().getNamedItem("T").getNodeValue()));
                
                allElements.add(in0d);
                
            }
            
            /***
             * Branch Aquisition
             */
            {
            
                NodeList inBC = doc.getElementsByTagName("branch");
                Node inBCNode;
                Branch1D work_branch;
                
                for (int i = 0 ; i < inBC.getLength() ; i++ ){
                
                    
                    inBCNode = inBC.item(i);

                    work_branch = new Branch1D(inBCNode.getAttributes().getNamedItem("name").getNodeValue(),
                                               Integer.parseInt( inBCNode.getAttributes().getNamedItem("n").getNodeValue() ),
                                               inBCNode.getAttributes().getNamedItem("father").getNodeValue(),
                                               inBCNode.getAttributes().getNamedItem("son").getNodeValue(),
                                               Float.parseFloat( inBCNode.getAttributes().getNamedItem("l").getNodeValue() ),
                                               Float.parseFloat( inBCNode.getAttributes().getNamedItem("E").getNodeValue() ),
                                               Float.parseFloat( inBCNode.getAttributes().getNamedItem("r").getNodeValue() ),
                                               Float.parseFloat( inBCNode.getAttributes().getNamedItem("h").getNodeValue() ),
                                               Float.parseFloat( inBCNode.getAttributes().getNamedItem("poiss").getNodeValue() ) );
                        
                
                allElements.add(work_branch);
                }
            }
            
            /****
             * Output Aquisition
             */
            {
   
                NodeList inBC = doc.getElementsByTagName("output");
                Node inBCNode = inBC.item(0); //consider the first only
                
                Output0D out0d = new Output0D(inBCNode.getAttributes().getNamedItem("name").getNodeValue(),
                                           inBCNode.getAttributes().getNamedItem("father").getNodeValue(), 
                                           Float.parseFloat(inBCNode.getAttributes().getNamedItem("R").getNodeValue())
                                           );
                
                allElements.add(out0d);
                
            }

        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(NetworkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return allElements;
        
    }
    

    
}
