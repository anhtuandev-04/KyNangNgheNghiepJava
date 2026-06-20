package bai5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Bai5GUI extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    private JTextField txtMaSV, txtHoTen, txtDiaChi, txtLop;

    public Bai5GUI() {
        setTitle("Quản Lý & Thủ Tục Lưu Trữ (Bài 5)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel pnlInput = new JPanel(new GridLayout(5, 2));
        pnlInput.setBorder(BorderFactory.createTitledBorder("Thêm Sinh Viên Mới (Sử dụng PreparedStatement)"));
        
        txtMaSV = new JTextField(); txtHoTen = new JTextField();
        txtDiaChi = new JTextField(); txtLop = new JTextField();
        JButton btnAdd = new JButton("Thêm Sinh Viên");

        pnlInput.add(new JLabel("Mã SV:")); pnlInput.add(txtMaSV);
        pnlInput.add(new JLabel("Họ Tên:")); pnlInput.add(txtHoTen);
        pnlInput.add(new JLabel("Địa Chỉ:")); pnlInput.add(txtDiaChi);
        pnlInput.add(new JLabel("Lớp:")); pnlInput.add(txtLop);
        pnlInput.add(new JLabel("")); pnlInput.add(btnAdd);

        add(pnlInput, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Thông tin kết quả từ Server"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel pnlActions = new JPanel(new GridLayout(2, 2));
        JButton btnProcA = new JButton("4a. Xem info Đề tài DT01");
        JButton btnProcB = new JButton("4b. Tìm SV điểm < 5");
        JButton btnProcE = new JButton("4e. Tự động Cập Nhật Xếp Loại");
        JButton btnViewKQ = new JButton("Xem Bảng Kết Quả");

        pnlActions.add(btnProcA);
        pnlActions.add(btnProcB);
        pnlActions.add(btnProcE);
        pnlActions.add(btnViewKQ);
        add(pnlActions, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> themSinhVien());

        btnProcA.addActionListener(e -> callProcA("DT01"));

        btnProcB.addActionListener(e -> callProcB(5.0f));

        btnProcE.addActionListener(e -> callProcE());

        btnViewKQ.addActionListener(e -> loadKetQuaTable());
    }

    private void themSinhVien() {
        String sql = "INSERT INTO SinhVien VALUES (?, ?, ?, ?)";
        try (Connection conn = SetupBai5.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, txtMaSV.getText());
            ps.setString(2, txtHoTen.getText());
            ps.setString(3, txtDiaChi.getText());
            ps.setString(4, txtLop.getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm SV thành công!");
            txtMaSV.setText(""); txtHoTen.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi thêm: " + ex.getMessage());
        }
    }

    private void callProcA(String maDT) {
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Tên ĐT", "Tên SV", "GV Hướng Dẫn"});
        String sql = "{ call Proc_GetDeTaiInfo(?) }";
        
        try (Connection conn = SetupBai5.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setString(1, maDT);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("TenDT"), rs.getString("TenSV"), rs.getString("TenGV")
                });
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    private void callProcB(float diemChuan) {
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Tên SV", "Điểm"});
        String sql = "{ call Proc_GetSV_LowScore(?) }";
        
        try (Connection conn = SetupBai5.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setFloat(1, diemChuan);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()) {
                model.addRow(new Object[]{ rs.getString("HoTen"), rs.getFloat("Diem") });
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    private void callProcE() {
        String sql = "{ call Proc_UpdateXepLoai() }";
        try (Connection conn = SetupBai5.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.execute();
            JOptionPane.showMessageDialog(this, "Đã cập nhật cột Xếp Loại cho toàn bộ sinh viên!");
            loadKetQuaTable(); 
            
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    private void loadKetQuaTable() {
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã SV", "Mã ĐT", "Điểm", "Xếp Loại"});
        try (Connection conn = SetupBai5.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM KetQua")) {
            
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("MaSV"), rs.getString("MaDT"), 
                    rs.getFloat("Diem"), rs.getString("XepLoai")
                });
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai5GUI().setVisible(true));
    }
}