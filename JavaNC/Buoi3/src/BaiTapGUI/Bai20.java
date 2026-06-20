//TruongAnhTuan 220616
package BaiTapGUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Bai20 extends JFrame implements ActionListener {
    private JTextField txtA, txtB, txtC, txtKetQua;
    private JButton btnGiai, btnXoa, btnThoat;

    public Bai20() {
        setTitle("Giải phương trình bậc 2");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JPanel pnTitle = new JPanel();
        pnTitle.setBackground(Color.LIGHT_GRAY);
        JLabel lblTitle = new JLabel("Giải phương trình bậc 2");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        pnTitle.add(lblTitle);
        add(pnTitle, BorderLayout.NORTH);

       
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        
        JPanel pnInput = new JPanel(new GridLayout(4, 2, 15, 15));
        pnInput.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.RED), "Nhập a,b,c"));

        pnInput.add(new JLabel("a:", SwingConstants.RIGHT));
        txtA = new JTextField(); pnInput.add(txtA);
        
        pnInput.add(new JLabel("b:", SwingConstants.RIGHT));
        txtB = new JTextField(); pnInput.add(txtB);
        
        pnInput.add(new JLabel("c:", SwingConstants.RIGHT));
        txtC = new JTextField(); pnInput.add(txtC);
        
        pnInput.add(new JLabel("Kết Quả", SwingConstants.RIGHT));
        txtKetQua = new JTextField();
        txtKetQua.setEditable(false); 
        pnInput.add(txtKetQua);

        pnCenter.add(pnInput);
        add(pnCenter, BorderLayout.CENTER);

        
        JPanel pnAction = new JPanel();
        pnAction.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE), "Chọn thao tác"));
        
        btnGiai = new JButton("Giải");
        btnXoa = new JButton("Xóa trắng");
        btnThoat = new JButton("Thoát");

        btnGiai.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);

        pnAction.add(btnGiai);
        pnAction.add(btnXoa);
        pnAction.add(btnThoat);
        add(pnAction, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btnThoat) {
            System.exit(0);
        } else if (source == btnXoa) {
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            txtKetQua.setText("");
            txtA.requestFocus();
        } else if (source == btnGiai) {
            giaiPT();
        }
    }

    private void giaiPT() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            if (a == 0) {
                if (b == 0) {
                    txtKetQua.setText(c == 0 ? "Vô số nghiệm" : "Vô nghiệm");
                } else {
                    txtKetQua.setText("x = " + (-c / b));
                }
            } else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    txtKetQua.setText("Phương trình vô nghiệm");
                } else if (delta == 0) {
                    txtKetQua.setText("Nghiệm kép x = " + (-b / (2 * a)));
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    txtKetQua.setText("x1 = " + x1 + " ; x2 = " + x2);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        new Bai20().setVisible(true);
    }
}