package com.capit.vesselsolver.util;

import java.io.File;
import java.io.IOException;
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
    
    public static void getFromFile(String fileLocation){
        
        try {
            
            File fXmlFile = new File(fileLocation);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("branch");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		//System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
			System.out.println("radius: " + eElement.getElementsByTagName("radius").item(0).getTextContent());
			

		}
	}
            
            
            
            
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(NetworkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
