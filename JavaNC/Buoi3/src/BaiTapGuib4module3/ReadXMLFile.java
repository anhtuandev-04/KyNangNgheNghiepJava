package BaiTapGuib4module3;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class ReadXMLFile {
    public static void main(String argv[]) {
        try {
            // Chỉ định file XML. Vì file nằm ở gốc Project nên chỉ cần tên file.
            File fXmlFile = new File("staff.xml");

            // Khởi tạo nhà máy sản xuất DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Phân tích cú pháp file XML để nạp vào cây đối tượng (DOM Tree)
            Document doc = dBuilder.parse(fXmlFile);

            // Chuẩn hóa cấu trúc để tránh các lỗi node trống/khoảng trắng thừa
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            // Lấy danh sách tất cả các thẻ <staff>
            NodeList nList = doc.getElementsByTagName("staff");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Truy xuất thuộc tính (Attribute)
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    
                    // Truy xuất nội dung text của các thẻ con (Tag Name)
                    System.out.println("First Name : " + 
                        eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + 
                        eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + 
                        eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + 
                        eElement.getElementsByTagName("salary").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }
}