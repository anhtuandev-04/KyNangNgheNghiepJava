package bai4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MainGUI extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public MainGUI() {
        setTitle("Quản Lý Thực Tập & Bảo Vệ Đề Tài (Bài 4)");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("BẢNG KẾT QUẢ BẢO VỆ ĐỀ TÀI", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(Color.BLUE);
        add(lblTitle, BorderLayout.NORTH);

        String[] columns = {"Mã SV", "Tên Sinh Viên", "Tên Đề Tài", "GV Hướng Dẫn", "Học Vị GV", "Điểm"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnReload = new JButton("Tải lại dữ liệu");
        btnReload.addActionListener(e -> loadData());
        add(btnReload, BorderLayout.SOUTH);

        loadData();
    }

    private void loadData() {
        model.setRowCount(0);
        String sql = "SELECT " +
                     "   sv.MaSV, sv.HoTen AS TenSV, " +
                     "   dt.TenDT, " +
                     "   gv.HoTen AS TenGV, " +
                     "   hv.TenHV, " +
                     "   kq.Diem " +
                     "FROM SinhVien sv " +
                     "JOIN SinhVien_DeTai svdt ON sv.MaSV = svdt.MaSV " +
                     "JOIN DeTai dt ON svdt.MaDT = dt.MaDT " +
                     "LEFT JOIN KetQua kq ON sv.MaSV = kq.MaSV AND dt.MaDT = kq.MaDT " +
                     "LEFT JOIN GiaoVien_DeTai gvdt ON dt.MaDT = gvdt.MaDT " +
                     "LEFT JOIN GiaoVien gv ON gvdt.MaGV = gv.MaGV " +
                     "LEFT JOIN HocVi hv ON gv.MaHV = hv.MaHV";

        try (Connection conn = SetupData.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("MaSV"),
                    rs.getString("TenSV"),
                    rs.getString("TenDT"),
                    rs.getString("TenGV"), 
                    rs.getString("TenHV"),
                    rs.getFloat("Diem")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}