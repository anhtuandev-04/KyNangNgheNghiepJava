//TruongAnhTuan 220616
package BaiTapGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai15 extends JFrame {
    private JLabel label;
    private JCheckBox bold, italic;

    public Bai15() {
        setTitle("Style Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(153, 204, 204)); 
        panel.setLayout(new GridLayout(2, 1));

        label = new JLabel("Say it with style!", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 36));

        bold = new JCheckBox("Bold");
        bold.setBackground(new Color(153, 204, 204));
        italic = new JCheckBox("Italic");
        italic.setBackground(new Color(153, 204, 204));

        JPanel checkPanel = new JPanel();
        checkPanel.setBackground(new Color(153, 204, 204));
        checkPanel.add(bold);
        checkPanel.add(italic);

        ItemListener listener = e -> {
            int style = Font.PLAIN;
            if (bold.isSelected()) style += Font.BOLD;
            if (italic.isSelected()) style += Font.ITALIC;
            label.setFont(new Font("Serif", style, 36));
        };

        bold.addItemListener(listener);
        italic.addItemListener(listener);

        panel.add(label);
        panel.add(checkPanel);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai15().setVisible(true));
    }
}