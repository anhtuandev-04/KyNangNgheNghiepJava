package BaiTapGUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Bai21 extends JFrame implements ActionListener {
    private JTextField txtA, txtB, txtKQ;
    private JButton btnGiai, btnXoa, btnThoat;
    private JRadioButton radCong, radTru, radNhan, radChia;

    public Bai21() {
        setTitle("Cộng - Trừ - Nhân - Chia");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Cộng Trừ Nhân Chia", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setPreferredSize(new Dimension(0, 50));
        add(lblTitle, BorderLayout.NORTH);

        JPanel pnWest = new JPanel();
        pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
        pnWest.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.RED), "Chọn tác vụ"));
        pnWest.setPreferredSize(new Dimension(100, 0));
        pnWest.setBackground(Color.LIGHT_GRAY);

        btnGiai = new JButton("Giải");
        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");

 
        btnGiai.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnXoa.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnThoat.setAlignmentX(Component.CENTER_ALIGNMENT);

        pnWest.add(Box.createVerticalStrut(10));
        pnWest.add(btnGiai);
        pnWest.add(Box.createVerticalStrut(10));
        pnWest.add(btnXoa);
        pnWest.add(Box.createVerticalStrut(10));
        pnWest.add(btnThoat);
        add(pnWest, BorderLayout.WEST);

        
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnCenter.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.RED), "nhập 2 số a và b:"));

        JPanel pna = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pna.add(new JLabel("nhập a: "));
        txtA = new JTextField(20);
        pna.add(txtA);
        pnCenter.add(pna);

        JPanel pnb = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnb.add(new JLabel("nhập b: "));
        txtB = new JTextField(20);
        pnb.add(txtB);
        pnCenter.add(pnb);

        JPanel pnPhepToan = new JPanel(new GridLayout(2, 2));
        pnPhepToan.setBorder(BorderFactory.createTitledBorder("Chọn phép toán:"));
        radCong = new JRadioButton("Cộng", true);
        radTru = new JRadioButton("Trừ");
        radNhan = new JRadioButton("Nhân");
        radChia = new JRadioButton("Chia");
        
        ButtonGroup group = new ButtonGroup();
        group.add(radCong); group.add(radTru);
        group.add(radNhan); group.add(radChia);

        pnPhepToan.add(radCong); pnPhepToan.add(radTru);
        pnPhepToan.add(radNhan); pnPhepToan.add(radChia);
        
        JPanel pnPhepToanWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnPhepToanWrapper.add(pnPhepToan);
        pnCenter.add(pnPhepToanWrapper);

        JPanel pnkq = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnkq.add(new JLabel("Kết quả: "));
        txtKQ = new JTextField(20);
        txtKQ.setEditable(false);
        pnkq.add(txtKQ);
        pnCenter.add(pnkq);

        add(pnCenter, BorderLayout.CENTER);

  
        JPanel pnSouth = new JPanel();
        pnSouth.setBackground(new Color(255, 182, 193));
        pnSouth.setPreferredSize(new Dimension(0, 30));
        
        JPanel p1 = new JPanel(); p1.setBackground(Color.BLUE); p1.setPreferredSize(new Dimension(15, 15));
        JPanel p2 = new JPanel(); p2.setBackground(Color.RED); p2.setPreferredSize(new Dimension(15, 15));
        JPanel p3 = new JPanel(); p3.setBackground(Color.YELLOW); p3.setPreferredSize(new Dimension(15, 15));
        pnSouth.add(p1); pnSouth.add(p2); pnSouth.add(p3);
        
        add(pnSouth, BorderLayout.SOUTH);
        btnGiai.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnThoat) {
            System.exit(0);
        } else if (src == btnXoa) {
            txtA.setText(""); txtB.setText(""); txtKQ.setText("");
            txtA.requestFocus();
        } else if (src == btnGiai) {
            tinhToan();
        }
    }

    private void tinhToan() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double kq = 0;

            if (radCong.isSelected()) kq = a + b;
            else if (radTru.isSelected()) kq = a - b;
            else if (radNhan.isSelected()) kq = a * b;
            else if (radChia.isSelected()) {
                if (b == 0) {
                    JOptionPane.showMessageDialog(this, "Không thể chia cho 0!");
                    return;
                }
                kq = a / b;
            }
            txtKQ.setText(String.valueOf(kq));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        new Bai21().setVisible(true);
    }
}