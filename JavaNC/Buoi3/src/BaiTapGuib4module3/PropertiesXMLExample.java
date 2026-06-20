package BaiTapGuib4module3;

import java.io.*;
import java.util.Properties;

public class PropertiesXMLExample {
    public static void main(String[] args) {
        try {
            // 1. Khởi tạo đối tượng Properties (Giống như một HashMap)
            Properties props = new Properties();
            
            // 2. Thiết lập các cặp Key - Value (Khóa - Giá trị)
            props.setProperty("email.support", "donot-spam-me@nospam.com");
            props.setProperty("database.url", "jdbc:mysql://localhost:3306/db");
            props.setProperty("app.version", "1.0.0");

            // 3. Khai báo nơi lưu trữ file (Tại thư mục gốc của Project)
            OutputStream os = new FileOutputStream("email-conf.xml");

            // 4. Lưu đối tượng properties vào file XML
            // Tham số: Outputstream, Comment (Ghi chú), Encoding (Bảng mã)
            props.storeToXML(os, "Support Email Config", "UTF-8");

            // Đóng luồng ghi
            os.close();

            System.out.println("Đã xuất file XML thành công: email-conf.xml");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}