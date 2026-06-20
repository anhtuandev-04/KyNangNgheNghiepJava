package bai5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SetupBai5 {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mod4_bai5", "root", "");
        } catch (Exception e) {
            e.printStackTrace(); return null;
        }
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            System.out.println("--- BẮT ĐẦU CÀI ĐẶT BÀI 5 ---");

            String[] drops = {
                "DROP PROCEDURE IF EXISTS Proc_GetDeTaiInfo",
                "DROP PROCEDURE IF EXISTS Proc_GetSV_LowScore",
                "DROP PROCEDURE IF EXISTS Proc_CountProject_GV",
                "DROP PROCEDURE IF EXISTS Proc_CountSV_InProject",
                "DROP PROCEDURE IF EXISTS Proc_UpdateXepLoai",
                "DROP TABLE IF EXISTS KetQua", "DROP TABLE IF EXISTS GiaoVien_DeTai",
                "DROP TABLE IF EXISTS SinhVien_DeTai", "DROP TABLE IF EXISTS GiaoVien",
                "DROP TABLE IF EXISTS DeTai", "DROP TABLE IF EXISTS SinhVien", "DROP TABLE IF EXISTS HocVi"
            };
            for (String sql : drops) stmt.executeUpdate(sql);

            stmt.executeUpdate("CREATE TABLE HocVi (MaHV VARCHAR(10) PRIMARY KEY, TenHV VARCHAR(50))");
            stmt.executeUpdate("CREATE TABLE SinhVien (MaSV VARCHAR(10) PRIMARY KEY, HoTen VARCHAR(50), DiaChi VARCHAR(100), Lop VARCHAR(20))");
            stmt.executeUpdate("CREATE TABLE DeTai (MaDT VARCHAR(10) PRIMARY KEY, TenDT VARCHAR(100))");
            stmt.executeUpdate("CREATE TABLE GiaoVien (MaGV VARCHAR(10) PRIMARY KEY, HoTen VARCHAR(50), DiaChi VARCHAR(100), MaHV VARCHAR(10))");
            stmt.executeUpdate("CREATE TABLE SinhVien_DeTai (MaSV VARCHAR(10), MaDT VARCHAR(10), PRIMARY KEY(MaSV, MaDT))");
            stmt.executeUpdate("CREATE TABLE GiaoVien_DeTai (MaGV VARCHAR(10), MaDT VARCHAR(10), PRIMARY KEY(MaGV, MaDT))");

            stmt.executeUpdate("CREATE TABLE KetQua (MaSV VARCHAR(10), MaDT VARCHAR(10), Diem FLOAT, XepLoai VARCHAR(20), PRIMARY KEY(MaSV, MaDT))");

            System.out.println("Đang nạp dữ liệu mẫu...");
            stmt.executeUpdate("INSERT INTO SinhVien VALUES ('SV01', 'Truong Anh Tuan', 'ST', 'Lop1'), ('SV02', 'Nguyen Quoc Tanh', 'Vinh Long', 'Lop1'), ('SV03', 'Pham Tran Tuan Vi', 'Tien Giang', 'Lop2')");
            stmt.executeUpdate("INSERT INTO DeTai VALUES ('DT01', 'Quan Ly So Tiet Kiem'), ('DT02', 'Web Ban Thiet Bi Di Dong')");
            stmt.executeUpdate("INSERT INTO GiaoVien VALUES ('GV01', 'Thay Phuc', 'Vinh Long', 'HV01')");
            stmt.executeUpdate("INSERT INTO SinhVien_DeTai VALUES ('SV01', 'DT01'), ('SV02', 'DT01'), ('SV03', 'DT02')");
            stmt.executeUpdate("INSERT INTO GiaoVien_DeTai VALUES ('GV01', 'DT01'), ('GV01', 'DT02')");
            stmt.executeUpdate("INSERT INTO KetQua (MaSV, MaDT, Diem) VALUES ('SV01', 'DT01', 8.5), ('SV02', 'DT01', 4.5), ('SV03', 'DT02', 6.5)");

            System.out.println("Đang tạo các thủ tục lưu trữ...");

            String procA = "CREATE PROCEDURE Proc_GetDeTaiInfo(IN p_MaDT VARCHAR(10)) " +
                           "BEGIN " +
                           " SELECT dt.TenDT, sv.HoTen AS TenSV, gv.HoTen AS TenGV " +
                           " FROM DeTai dt " +
                           " JOIN SinhVien_DeTai svdt ON dt.MaDT = svdt.MaDT " +
                           " JOIN SinhVien sv ON svdt.MaSV = sv.MaSV " +
                           " JOIN GiaoVien_DeTai gvdt ON dt.MaDT = gvdt.MaDT " +
                           " JOIN GiaoVien gv ON gvdt.MaGV = gv.MaGV " +
                           " WHERE dt.MaDT = p_MaDT; " +
                           "END";
            stmt.executeUpdate(procA);

            String procB = "CREATE PROCEDURE Proc_GetSV_LowScore(IN p_DiemChuan FLOAT) " +
                           "BEGIN " +
                           " SELECT sv.HoTen, kq.Diem " +
                           " FROM KetQua kq " +
                           " JOIN SinhVien sv ON kq.MaSV = sv.MaSV " +
                           " WHERE kq.Diem < p_DiemChuan; " +
                           "END";
            stmt.executeUpdate(procB);

            String procC = "CREATE PROCEDURE Proc_CountProject_GV(IN p_MaGV VARCHAR(10), OUT p_Count INT) " +
                           "BEGIN " +
                           " SELECT COUNT(*) INTO p_Count FROM GiaoVien_DeTai WHERE MaGV = p_MaGV; " +
                           "END";
            stmt.executeUpdate(procC);

            String procD = "CREATE PROCEDURE Proc_CountSV_InProject(IN p_MaDT VARCHAR(10), OUT p_Count INT) " +
                           "BEGIN " +
                           " SELECT COUNT(*) INTO p_Count FROM SinhVien_DeTai WHERE MaDT = p_MaDT; " +
                           "END";
            stmt.executeUpdate(procD);

            String procE = "CREATE PROCEDURE Proc_UpdateXepLoai() " +
                           "BEGIN " +
                           " UPDATE KetQua SET XepLoai = CASE " +
                           "  WHEN Diem < 5 THEN 'Yếu' " +
                           "  WHEN Diem >= 5 AND Diem < 7 THEN 'Trung Bình' " +
                           "  WHEN Diem >= 7 AND Diem < 8 THEN 'Khá' " +
                           "  ELSE 'Giỏi' " +
                           " END; " +
                           "END";
            stmt.executeUpdate(procE);

            System.out.println("=== CÀI ĐẶT THÀNH CÔNG! HỆ THỐNG ĐÃ SẴN SÀNG ===");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}