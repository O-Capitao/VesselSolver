package com.capit.vesselsolver.util;

import com.capit.vesselsolver.entity.AbsElement;
import com.capit.vesselsolver.entity.Input0D;
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
             * TODO:
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
            

            
            
            
            
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(NetworkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return allElements;
        
    }
    

    
}
