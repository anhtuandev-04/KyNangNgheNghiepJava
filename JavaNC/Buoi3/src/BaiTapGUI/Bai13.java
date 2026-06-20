//TruongAnhTuan 220616
package BaiTapGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai13 extends JFrame {
    private JTextField fahrenheitField;
    private JLabel resultLabel;

    public Bai13() {
        setTitle("Fahrenheit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 130);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(242, 212, 53));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        Font font = new Font("Arial", Font.BOLD, 14);

        JLabel label1 = new JLabel("Enter Fahrenheit temperature:");
        label1.setFont(font);

        fahrenheitField = new JTextField(5);
        fahrenheitField.setFont(font);

        JLabel label2 = new JLabel("Temperature in Celsius:");
        label2.setFont(font);

        resultLabel = new JLabel("---");
        resultLabel.setFont(font);
        fahrenheitField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = fahrenheitField.getText();
                    int fValue = Integer.parseInt(text);
                    int cValue = (fValue - 32) * 5 / 9; 
                    resultLabel.setText(String.valueOf(cValue));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("?"); 
                }
            }
        });

        panel.add(label1);
        panel.add(fahrenheitField);
        panel.add(label2);
        panel.add(resultLabel);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai13().setVisible(true);
        });
    }
}