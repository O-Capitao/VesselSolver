package com.capit.vesselsolver.util;

import com.capit.vesselsolver.entity.AbsElement;
import com.capit.vesselsolver.entity.Branch1D;
import com.capit.vesselsolver.entity.Input0D;
import com.capit.vesselsolver.entity.Output0D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author capitaoF
 */
public class NetworkGenerator {
    
    public static List<AbsElement> getElementsFromFile(String fileLocation){
        
        
        List<AbsElement> allElements = new ArrayList<>();
        
        
        try {
            
            File fXmlFile = new File(fileLocation);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
   
            /***
             * Input BC Importer
             * TODO: outlets
             */
            {
   
                NodeList inBC = doc.getElementsByTagName("input");
                Node inBCNode = inBC.item(0); //consider the first only
                
                Input0D in0d = new Input0D(inBCNode.getAttributes().getNamedItem("name").getNodeValue(),
                                           inBCNode.getAttributes().getNamedItem("son").getNodeValue(), 
                                           Float.parseFloat(inBCNode.getAttributes().getNamedItem("amp").getNodeValue()),
                                           Float.parseFloat(inBCNode.getAttributes().getNamedItem("T").getNodeValue()),
                                           10);
                
                allElements.add(in0d);
                
            }
            
            //For the branches
            {
            
                NodeList inBC = doc.getElementsByTagName("branch");
                Node inBCNode;
                Branch1D work_branch;
                for (int i = 0 ; i > inBC.getLength() ; i++ ){
                
                    inBCNode = inBC.item(i);

                    work_branch = new Branch1D(inBCNode.getAttributes().getNamedItem("name").getNodeValue(),
                                               5, //default value - TODO: Dynamic -> Minimum work vs MAximum precision
                                               inBCNode.getAttributes().getNamedItem("father").getNodeValue(),
                                               inBCNode.getAttributes().getNamedItem("son").getNodeValue() );
                
                allElements.add(work_branch);
                }
            }
            
            
            //String name, String father, float R
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
