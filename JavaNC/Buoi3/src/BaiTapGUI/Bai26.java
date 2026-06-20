package BaiTapGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai26 extends JFrame implements ActionListener {
    private JTextField txtN;
    private JTextArea areaResult;
    private JButton btnGenerate;

    public Bai26() {
        setTitle("Prime Numbers Generator");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel pnlTop = new JPanel();
        pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        txtN = new JTextField(10);
        btnGenerate = new JButton("Generate");
        
        pnlTop.add(txtN);
        pnlTop.add(btnGenerate);

        areaResult = new JTextArea();
        areaResult.setEditable(false);
        areaResult.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scroll = new JScrollPane(areaResult);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));

        add(pnlTop, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnGenerate.addActionListener(this);
        txtN.addActionListener(this);
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(txtN.getText().trim());
            if (n <= 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lớn hơn 0!");
                return;
            }
            
            areaResult.setText("");
            int count = 0;
            int num = 2;
            StringBuilder sb = new StringBuilder();
            
            while (count < n) {
                if (isPrime(num)) {
                    sb.append(num).append("\n");
                    count++;
                }
                num++;
            }
            areaResult.setText(sb.toString());
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai26().setVisible(true);
        });
    }
}