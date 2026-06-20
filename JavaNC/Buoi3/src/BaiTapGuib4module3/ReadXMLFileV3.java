package BaiTapGuib4module3;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFileV3 {
    public static void main(String argv[]) {
        try {
            // 1. Tạo Factory và SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // 2. Định nghĩa Handler để xử lý các sự kiện XML
            DefaultHandler handler = new DefaultHandler() {
                // Các biến cờ (flags) để xác định vị trí thẻ đang đọc
                boolean bfname = false;
                boolean blname = false;
                boolean bnname = false;
                boolean bsalary = false;

                // Sự kiện: Bắt đầu một thẻ (Mở thẻ)
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) 
                        throws SAXException {
                    System.out.println("Start Element :" + qName);
                    
                    // Kiểm tra tên thẻ để bật cờ tương ứng
                    if (qName.equalsIgnoreCase("FIRSTNAME")) bfname = true;
                    if (qName.equalsIgnoreCase("LASTNAME")) blname = true;
                    if (qName.equalsIgnoreCase("NICKNAME")) bnname = true;
                    if (qName.equalsIgnoreCase("SALARY")) bsalary = true;
                }

                // Sự kiện: Kết thúc một thẻ (Đóng thẻ)
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element :" + qName);
                }

                // Sự kiện: Đọc nội dung văn bản bên trong thẻ
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bfname) {
                        System.out.println("First Name : " + new String(ch, start, length));
                        bfname = false; // Đọc xong thì tắt cờ
                    }
                    if (blname) {
                        System.out.println("Last Name : " + new String(ch, start, length));
                        blname = false;
                    }
                    if (bnname) {
                        System.out.println("Nick Name : " + new String(ch, start, length));
                        bnname = false;
                    }
                    if (bsalary) {
                        System.out.println("Salary : " + new String(ch, start, length));
                        bsalary = false;
                    }
                }
            };

            // 3. Tiến hành phân tích file
            saxParser.parse("file.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}