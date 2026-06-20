package BaiTapGuib4module3;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ReadXMLFile2 {
    public static void main(String[] args) {
        try {
            File file = new File("staff.xml");
            
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            
            if (doc.hasChildNodes()) {
                printNote(doc.getChildNodes());
            }
            
        } 
        catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void printNote(NodeList nodeList) {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                
                System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");

                if (!tempNode.hasChildNodes() || tempNode.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                }

                if (tempNode.hasAttributes()) {
                    NamedNodeMap nodeMap = tempNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());
                    }
                }

                if (tempNode.hasChildNodes()) {
                    printNote(tempNode.getChildNodes());
                }

                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
            }
        }
    }
}