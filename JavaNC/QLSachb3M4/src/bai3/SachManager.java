package bai3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class SachManager extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtSearch;

    public SachManager() {
        setTitle("Quản Lý Sách Thư Viện");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel pnlTop = new JPanel();
        txtSearch = new JTextField(20);
        JButton btnSearch = new JButton("Tìm Kiếm");
        JButton btnPrint = new JButton("In ra Console (Task 4)");
        
        pnlTop.add(new JLabel("Nhập tên sách: "));
        pnlTop.add(txtSearch);
        pnlTop.add(btnSearch);
        pnlTop.add(btnPrint);
        
        add(pnlTop, BorderLayout.NORTH);

        String[] cols = {"Mã Sách", "Tựa Sách", "Tác Giả", "Năm XB", "NXB"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        loadData(""); 

        btnSearch.addActionListener(e -> {
            String keyword = txtSearch.getText();
            loadData(keyword);
        });

        btnPrint.addActionListener(e -> printToConsole());
    }

    private void loadData(String keyword) {
        model.setRowCount(0);
        String sql = "SELECT s.MaSach, s.TuSach, tg.TenTG, s.NamXB, s.NXB " +
                     "FROM tblSach s " +
                     "JOIN tblTacGia tg ON s.MaTG = tg.MaTG";
        
        if (!keyword.isEmpty()) {
            sql += " WHERE s.TuSach LIKE '%" + keyword + "%'";
        }

        try (Connection conn = DbConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("MaSach"),
                    rs.getString("TuSach"),
                    rs.getString("TenTG"),
                    rs.getInt("NamXB"),
                    rs.getString("NXB")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void printToConsole() {
        System.out.println("\n=== DANH SÁCH SÁCH (CONSOLE TASK 4) ===");
        String sql = "SELECT * FROM tblSach";
        try (Connection conn = DbConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                System.out.println(rs.getString("MaSach") + " - " + 
                                   rs.getString("TuSach") + " - " + 
                                   rs.getString("NXB"));
            }
            System.out.println("=======================================");
            JOptionPane.showMessageDialog(this, "Đã in danh sách ra Console Eclipse!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SachManager().setVisible(true));
    }
}