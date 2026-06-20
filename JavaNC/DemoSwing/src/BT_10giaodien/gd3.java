//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;

public class gd3 extends JFrame {
    public gd3() {
        setTitle("400 x 150");
        setSize(420, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        mainPanel.setBackground(Color.WHITE);

        mainPanel.add(createBlock("Red 1", Color.RED, 130));
        mainPanel.add(createBlock("Green 1", new Color(144, 238, 144), 120));
        mainPanel.add(createBlock("Blue 1", new Color(173, 216, 230), 100));

        mainPanel.add(createBlock("Yellow 1", Color.YELLOW, 60));
        mainPanel.add(createBlock("Orange 1", Color.ORANGE, 130));
        mainPanel.add(createBlock("Red 2", Color.RED, 120));

        mainPanel.add(createBlock("Green 2", new Color(144, 238, 144), 150));
        mainPanel.add(createBlock("Blue 2", new Color(173, 216, 230), 65));
        mainPanel.add(createBlock("Yellow 2", Color.YELLOW, 60));

        mainPanel.add(createBlock("Orange 2", Color.ORANGE, 170));

        add(mainPanel);
    }

    private JPanel createBlock(String text, Color color, int width) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 8));
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(width, 35));
        
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new gd3().setVisible(true);
        });
    }
}