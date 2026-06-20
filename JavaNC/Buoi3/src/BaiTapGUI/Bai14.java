//TruongAnhTuan 220616
package BaiTapGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai14 extends JFrame {
    private JTextField fahrenheitField;
    private JLabel resultLabel;
    private JButton convertButton;

    public Bai14() {
        setTitle("Temperature Conversion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 150);
        setLocationRelativeTo(null);

   
        JPanel panel = new JPanel();
        panel.setBackground(new Color(242, 212, 53)); 
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        Font font = new Font("Arial", Font.BOLD, 14);

        JLabel label1 = new JLabel("Enter Fahrenheit temperature:");
        label1.setFont(font);

        fahrenheitField = new JTextField(5);
        fahrenheitField.setFont(font);

        convertButton = new JButton("Convert");
        convertButton.setFont(font);

        JLabel label2 = new JLabel("Temperature in Celsius:");
        label2.setFont(font);

        resultLabel = new JLabel("---");
        resultLabel.setFont(font);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = fahrenheitField.getText();
                    int fValue = Integer.parseInt(text);
                    int cValue = (fValue - 32) * 5 / 9;
                    resultLabel.setText(String.valueOf(cValue));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Lỗi!");
                }
            }
        };

        fahrenheitField.addActionListener(listener);
        convertButton.addActionListener(listener);

        panel.add(label1);
        panel.add(fahrenheitField);
        panel.add(convertButton);
        panel.add(label2);
        panel.add(resultLabel);

        add(panel);
    }

    public static void main(String[] args) {
        new Bai14().setVisible(true);
    }
}