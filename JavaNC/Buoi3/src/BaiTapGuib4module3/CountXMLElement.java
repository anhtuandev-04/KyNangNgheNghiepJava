package BaiTapGuib4module3;

import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class CountXMLElement {
    public static void main(String argv[]) {
        try {
            // Đường dẫn đến file XML đã tạo ở bước 1
            String filepath = "file.xml";
            
            // Khởi tạo các đối tượng DOM Parser
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Tìm tất cả các Node có tên thẻ là "staff"
            NodeList list = doc.getElementsByTagName("staff");

            // Hiển thị số lượng phần tử tìm thấy
            System.out.println("Total of staff elements : " + list.getLength());
            
            // Thử thách thêm: Đếm xem có bao nhiêu nhân viên có thẻ <age>
            int countAge = 0;
            for (int i = 0; i < list.getLength(); i++) {
                Element staff = (Element) list.item(i);
                if (staff.getElementsByTagName("age").getLength() > 0) {
                    countAge++;
                }
            }
            System.out.println("Total of staff with age tag: " + countAge);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            System.err.println("Không tìm thấy file: " + ioe.getMessage());
        } catch (SAXException sae) {
            System.err.println("Định dạng XML bị lỗi: " + sae.getMessage());
        }
    }
}