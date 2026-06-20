package BaiTapGUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Bai24 extends JFrame implements ActionListener {
    private DefaultListModel<Integer> listModel;
    private JList<Integer> list;
    private JTextField txtInput;
    private JCheckBox chkAm;
    private JButton btnNhap, btnChan, btnLe, btnNguyenTo, btnBoToDen, btnXoa, btnTong, btnDong;

    public Bai24() {
        setTitle("Thao tác trên JList");
        setSize(650, 500);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        
        JLabel lblTitle = new JLabel("Thao tác trên JList - Checkbox", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLUE);
        add(lblTitle, BorderLayout.NORTH);

        // Chọn tác vụ
        JPanel pnWest = new JPanel();
        pnWest.setLayout(new GridLayout(6, 1, 5, 10));
        pnWest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Chọn tác vụ"));

        btnChan = new JButton("Tô đen số chẵn");
        btnLe = new JButton("Tô đen số lẻ");
        btnNguyenTo = new JButton("Tô đen số nguyên tố");
        btnBoToDen = new JButton("Bỏ tô đen");
        btnXoa = new JButton("Xóa các giá trị đang tô đen");
        btnTong = new JButton("Tổng giá trị trong JList");

        pnWest.add(btnChan); pnWest.add(btnLe); pnWest.add(btnNguyenTo);
        pnWest.add(btnBoToDen); pnWest.add(btnXoa); pnWest.add(btnTong);
        add(pnWest, BorderLayout.WEST);

        //  Nhập thông tin và JList
        JPanel pnCenter = new JPanel(new BorderLayout(5, 5));
        pnCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Nhập thông tin:"));

        //  nhập liệu 
        JPanel pnInput = new JPanel(new FlowLayout());
        btnNhap = new JButton("Nhập");
        txtInput = new JTextField(10);
        chkAm = new JCheckBox("Cho nhập số âm");
        pnInput.add(btnNhap);
        pnInput.add(txtInput);
        pnInput.add(chkAm);
        pnCenter.add(pnInput, BorderLayout.NORTH);

        // JList hiển thị dữ liệu
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        pnCenter.add(new JScrollPane(list), BorderLayout.CENTER);
        add(pnCenter, BorderLayout.CENTER);

        // Nút đóng chương trình 
        JPanel pnSouth = new JPanel();
        btnDong = new JButton("Đóng chương trình");
        pnSouth.add(btnDong);
        pnSouth.setBorder(BorderFactory.createLineBorder(Color.RED));
        add(pnSouth, BorderLayout.SOUTH);

        // Đăng ký sự kiện
        btnNhap.addActionListener(this);
        btnChan.addActionListener(this);
        btnLe.addActionListener(this);
        btnNguyenTo.addActionListener(this);
        btnBoToDen.addActionListener(this);
        btnXoa.addActionListener(this);
        btnTong.addActionListener(this);
        btnDong.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnNhap) {
            try {
                int val = Integer.parseInt(txtInput.getText().trim());
                if (val < 0 && !chkAm.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Không được phép nhập số âm!");
                } else {
                    listModel.addElement(val);
                    txtInput.setText("");
                    txtInput.requestFocus();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên!");
            }
        } 
        else if (src == btnChan) {
            selectByCondition(0); // 0: chẵn
        } 
        else if (src == btnLe) {
            selectByCondition(1); // 1: lẻ
        } 
        else if (src == btnNguyenTo) {
            selectByCondition(2); // 2: nguyên tố
        } 
        else if (src == btnBoToDen) {
            list.clearSelection();
        } 
        else if (src == btnXoa) {
            int[] indices = list.getSelectedIndices();
            for (int i = indices.length - 1; i >= 0; i--) {
                listModel.remove(indices[i]);
            }
        } 
        else if (src == btnTong) {
            long tong = 0;
            for (int i = 0; i < listModel.size(); i++) {
                tong += listModel.getElementAt(i);
            }
            JOptionPane.showMessageDialog(this, "Tổng các giá trị trong JList: " + tong);
        } 
        else if (src == btnDong) {
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn đóng chương trình không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) System.exit(0);
        }
    }

    private void selectByCondition(int type) {
        list.clearSelection();
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < listModel.size(); i++) {
            int n = listModel.getElementAt(i);
            boolean match = false;
            if (type == 0 && n % 2 == 0) match = true;
            else if (type == 1 && n % 2 != 0) match = true;
            else if (type == 2 && isPrime(n)) match = true;

            if (match) indices.add(i);
        }
        int[] result = indices.stream().mapToInt(i -> i).toArray();
        list.setSelectedIndices(result);
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai24().setVisible(true));
    }
}