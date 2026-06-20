//TruongAnhTuan 220616
package BaiTapGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai18a extends JPanel implements ActionListener {
    private JTextField inputField, outputField;
    private JButton doubleButton, exitButton;

    public Bai18a() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        
        add(new JLabel("Enter a number"));
        inputField = new JTextField(5);
        add(inputField);

        doubleButton = new JButton("Double is");
        doubleButton.addActionListener(this);
        add(doubleButton);

        outputField = new JTextField(5);
        outputField.setEditable(false);
        add(outputField);

        exitButton = new JButton("exit");
        exitButton.addActionListener(this);
        add(exitButton);

        setPreferredSize(new Dimension(400, 200));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == doubleButton) {
            try {
                int val = Integer.parseInt(inputField.getText());
                outputField.setText(String.valueOf(val * 2));
            } catch (NumberFormatException ex) {
                outputField.setText("Error");
            }
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Event handling");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Bai18a());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}