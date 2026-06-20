package BaiTapGuib4module3;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ModifyXMLFile {
    public static void main(String argv[]) {
        try {
            String filepath = "file.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // 1. Cập nhật thuộc tính (id từ 1 -> 2)
            Node staff = doc.getElementsByTagName("staff").item(0);
            NamedNodeMap attr = staff.getAttributes();
            Node nodeAttr = attr.getNamedItem("id");
            nodeAttr.setTextContent("2");

            // 2. Thêm một Element mới (Thêm thẻ <age> vào staff)
            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode("28"));
            staff.appendChild(age);

            // 3 & 4. Cập nhật giá trị và Xóa thành phần
            NodeList list = staff.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                // Cập nhật lương (salary)
                if ("salary".equals(node.getNodeName())) {
                    node.setTextContent("2000000");
                }

                // Xóa tên (firstname)
                if ("firstname".equals(node.getNodeName())) {
                    staff.removeChild(node);
                }
            }

            // BƯỚC QUAN TRỌNG: Ghi nội dung đã sửa đổi từ bộ nhớ RAM xuống File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            // Định dạng lại XML cho đẹp (có xuống dòng và thụt lề)
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            System.out.println("Đã cập nhật file thành công!");

        } catch (ParserConfigurationException | TransformerException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}