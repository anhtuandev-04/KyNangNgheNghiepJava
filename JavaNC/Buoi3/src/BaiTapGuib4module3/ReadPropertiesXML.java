package BaiTapGuib4module3;

import java.io.*;
import java.util.Properties;

public class ReadPropertiesXML {
    public static void main(String[] args) {
        try {
            // 1. Khởi tạo đối tượng Properties trống
            Properties props = new Properties();

            // 2. Tạo luồng đọc file XML từ thư mục gốc Project
            File file = new File("email-conf.xml");
            
            // Kiểm tra file có tồn tại không trước khi đọc
            if (file.exists()) {
                InputStream is = new FileInputStream(file);

            // 3. Nạp (load) nội dung từ XML vào đối tượng Properties
                props.loadFromXML(is);

            // 4. Lấy giá trị dựa vào "Key" (email.support)
                String email = props.getProperty("email.support");

            // Hiển thị kết quả ra Console
                System.out.println("Email tìm thấy trong cấu hình: " + email);
                
                is.close();
            } else {
                System.out.println("Lỗi: Không tìm thấy file email-configuration.xml");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}