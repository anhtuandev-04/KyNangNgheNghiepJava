package bai1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Bai1GUI extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtMaLoai, txtTenLoai;

    public Bai1GUI() {
        setTitle("Quản Lý Sản Phẩm - Bài 1");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- PHẦN 1: Bảng hiển thị (Task a) ---
        String[] columnNames = {"Mã SP", "Tên SP", "Tên Loại SP"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // --- PHẦN 2: Form nhập liệu (Task b) ---
        JPanel panelInput = new JPanel(new GridLayout(3, 2));
        panelInput.setBorder(BorderFactory.createTitledBorder("Thêm Loại Sản Phẩm Mới"));

        txtMaLoai = new JTextField();
        txtTenLoai = new JTextField();
        JButton btnThem = new JButton("Thêm Loại SP");

        panelInput.add(new JLabel("Mã Loại:"));
        panelInput.add(txtMaLoai);
        panelInput.add(new JLabel("Tên Loại:"));
        panelInput.add(txtTenLoai);
        panelInput.add(new JLabel("")); // Placeholder
        panelInput.add(btnThem);

        add(panelInput, BorderLayout.SOUTH);

        // --- SỰ KIỆN ---
        loadData(); // Load dữ liệu khi mở app

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themLoaiSP();
            }
        });
    }

    // Hàm load dữ liệu từ SQL lên JTable
    private void loadData() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        String sql = "SELECT sp.MaSP, sp.TenSP, lsp.TenLoaiSP " +
                     "FROM SanPham sp " +
                     "JOIN LoaiSanPham lsp ON sp.MaLoaiSP = lsp.MaLoaiSP";

        try (Connection conn = DbUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String ma = rs.getString("MaSP");
                String ten = rs.getString("TenSP");
                String loai = rs.getString("TenLoaiSP");
                tableModel.addRow(new Object[]{ma, ten, loai});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + ex.getMessage());
        }
    }

    // Hàm thêm loại sản phẩm
    private void themLoaiSP() {
        String ma = txtMaLoai.getText();
        String ten = txtTenLoai.getText();

        if (ma.isEmpty() || ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!");
            return;
        }

        String sql = "INSERT INTO LoaiSanPham VALUES (?, ?)";

        try (Connection conn = DbUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ma);
            ps.setString(2, ten);

            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                txtMaLoai.setText("");
                txtTenLoai.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi thêm: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai1GUI().setVisible(true));
    }
}