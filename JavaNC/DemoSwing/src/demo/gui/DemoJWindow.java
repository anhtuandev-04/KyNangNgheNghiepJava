//Trương Anh Tuấn 220616
package demo.gui; 
import javax.swing.*;
import java.awt.*;

public class DemoJWindow {

    public static void main(String[] args) {
        // Tạo JWindow
        JWindow window = new JWindow();

        // Tạo nội dung
        JLabel lbl = new JLabel("Welcome to Java Swing", JLabel.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        lbl.setForeground(Color.WHITE);

        // Panel nền
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BorderLayout());
        panel.add(lbl, BorderLayout.CENTER);

        // Thêm panel vào window
        window.add(panel);

        // Thiết lập kích thước
        window.setSize(400, 200);

        // Canh giữa màn hình
        window.setLocationRelativeTo(null);

        // Hiển thị
        window.setVisible(true);

        // Tự động đóng sau 3 giây
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.dispose();
    }
}
