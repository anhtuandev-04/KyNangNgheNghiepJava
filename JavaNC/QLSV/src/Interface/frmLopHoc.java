package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import Proccess.LopHocDAL;
import java.awt.Font;

public class frmLopHoc extends JFrame {
    private LopHocDAL dal = new LopHocDAL();
    private JTextField txtMa, txtTen, txtGV;
    private JButton btnThem, btnSua, btnXoa, btnLuu, btnHuy, btnXemSV;
    private JTable tbl;
    private DefaultTableModel model;
    private boolean isEdit = false; 
    private JLabel lblNewLabel;
    
    public frmLopHoc() {
        setTitle("THÔNG TIN LỚP HỌC");
        setSize(700, 485);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        // Giao diện
        JLabel l1 = new JLabel("Mã số lớp:"); l1.setBounds(30, 60, 80, 25); getContentPane().add(l1);
        txtMa = new JTextField(); txtMa.setBounds(110, 60, 150, 25); getContentPane().add(txtMa);

        JLabel l2 = new JLabel("Tên lớp:"); l2.setBounds(310, 60, 80, 25); getContentPane().add(l2);
        txtTen = new JTextField(); txtTen.setBounds(390, 60, 200, 25); getContentPane().add(txtTen);

        JLabel l3 = new JLabel("Giáo viên CN:"); l3.setBounds(30, 100, 100, 25); getContentPane().add(l3);
        txtGV = new JTextField(); txtGV.setBounds(130, 100, 200, 25); getContentPane().add(txtGV);

        btnThem = new JButton("Thêm"); btnThem.setBounds(30, 140, 80, 30); getContentPane().add(btnThem);
        btnSua = new JButton("Sửa"); btnSua.setBounds(120, 140, 80, 30); getContentPane().add(btnSua);
        btnXoa = new JButton("Xóa"); btnXoa.setBounds(210, 140, 80, 30); getContentPane().add(btnXoa);
        btnLuu = new JButton("Lưu"); btnLuu.setBounds(300, 140, 80, 30); getContentPane().add(btnLuu);
        btnHuy = new JButton("Hủy"); btnHuy.setBounds(390, 140, 80, 30); getContentPane().add(btnHuy);
        btnXemSV = new JButton("Xem danh sách sinh viên lớp hiện tại"); 
        btnXemSV.setBounds(370, 392, 300, 30); getContentPane().add(btnXemSV);

        model = new DefaultTableModel(new String[]{"Mã Lớp", "Tên Lớp", "GV Chủ Nhiệm"}, 0);
        tbl = new JTable(model);
        JScrollPane sp = new JScrollPane(tbl); sp.setBounds(30, 181, 640, 200); getContentPane().add(sp);

        loadData();
        setControlState(true); 

        // Sự kiện
        btnThem.addActionListener(e -> {
            isEdit = false;
            setControlState(false);
            clearFields();
        });

        btnSua.addActionListener(e -> {
            if(txtMa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn lớp để sửa!");
                return;
            }
            isEdit = true;
            setControlState(false);
            txtMa.setEnabled(false); // Không cho sửa Mã (Khóa chính)
            
            lblNewLabel = new JLabel("THÔNG TIN LỚP HỌC");
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
            lblNewLabel.setBounds(229, 0, 241, 49);
            getContentPane().add(lblNewLabel);
        });

        btnHuy.addActionListener(e -> {
            setControlState(true);
            loadData();
        });

        btnLuu.addActionListener(e -> {
            try {
                if (isEdit) dal.update(txtMa.getText(), txtTen.getText(), txtGV.getText());
                else dal.insert(txtMa.getText(), txtTen.getText(), txtGV.getText());
                
                JOptionPane.showMessageDialog(this, "Lưu thành công!");
                setControlState(true);
                loadData();
            } catch (SQLException ex) { JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage()); }
        });

        btnXemSV.addActionListener(e -> {
            String maLop = txtMa.getText();
            if(maLop.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn lớp!");
            } else {
                new frmSinhVien(maLop).setVisible(true); // Mở Form 2
            }
        });

        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = tbl.getSelectedRow();
                txtMa.setText(model.getValueAt(r, 0).toString());
                txtTen.setText(model.getValueAt(r, 1).toString());
                txtGV.setText(model.getValueAt(r, 2).toString());
            }
        });
    }

    private void setControlState(boolean b) {
        txtMa.setEnabled(!b); txtTen.setEnabled(!b); txtGV.setEnabled(!b);
        btnThem.setEnabled(b); btnSua.setEnabled(b); btnXoa.setEnabled(b);
        btnLuu.setEnabled(!b); btnHuy.setEnabled(!b);
    }

    private void clearFields() { 
    	txtMa.setText(""); txtTen.setText(""); txtGV.setText(""); 
    	}

    private void loadData() {
        try {
            model.setRowCount(0);
            ResultSet rs = dal.getAll();
            while(rs.next()) model.addRow(new Object[]{
            		rs.getString(1), rs.getString(2), rs.getString(3)
            		});
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) { 
    	new frmLopHoc().setVisible(true); 
    	}
}