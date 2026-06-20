package bai4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SetupData {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mod4_bai4", "root", "");
        } catch (Exception e) {
            e.printStackTrace(); return null;
        }
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            System.out.println("Đang thiết lập CSDL cho Bài 4...");

            String[] dropTables = {
                "DROP TABLE IF EXISTS KetQua", "DROP TABLE IF EXISTS GiaoVien_DeTai",
                "DROP TABLE IF EXISTS SinhVien_DeTai", "DROP TABLE IF EXISTS GiaoVien",
                "DROP TABLE IF EXISTS DeTai", "DROP TABLE IF EXISTS SinhVien", "DROP TABLE IF EXISTS HocVi"
            };
            for (String sql : dropTables) stmt.executeUpdate(sql);

            stmt.executeUpdate("CREATE TABLE HocVi (MaHV VARCHAR(10) PRIMARY KEY, TenHV VARCHAR(50))");

            stmt.executeUpdate("CREATE TABLE SinhVien (MaSV VARCHAR(10) PRIMARY KEY, HoTen VARCHAR(50), DiaChi VARCHAR(100), Lop VARCHAR(20))");

            stmt.executeUpdate("CREATE TABLE DeTai (MaDT VARCHAR(10) PRIMARY KEY, TenDT VARCHAR(100))");

            stmt.executeUpdate("CREATE TABLE GiaoVien (MaGV VARCHAR(10) PRIMARY KEY, HoTen VARCHAR(50), DiaChi VARCHAR(100), MaHV VARCHAR(10), FOREIGN KEY (MaHV) REFERENCES HocVi(MaHV))");
            
            stmt.executeUpdate("CREATE TABLE SinhVien_DeTai (MaSV VARCHAR(10), MaDT VARCHAR(10), PRIMARY KEY(MaSV, MaDT), FOREIGN KEY (MaSV) REFERENCES SinhVien(MaSV), FOREIGN KEY (MaDT) REFERENCES DeTai(MaDT))");
            stmt.executeUpdate("CREATE TABLE GiaoVien_DeTai (MaGV VARCHAR(10), MaDT VARCHAR(10), PRIMARY KEY(MaGV, MaDT), FOREIGN KEY (MaGV) REFERENCES GiaoVien(MaGV), FOREIGN KEY (MaDT) REFERENCES DeTai(MaDT))");

            stmt.executeUpdate("CREATE TABLE KetQua (MaSV VARCHAR(10), MaDT VARCHAR(10), Diem FLOAT, PRIMARY KEY(MaSV, MaDT), FOREIGN KEY (MaSV) REFERENCES SinhVien(MaSV), FOREIGN KEY (MaDT) REFERENCES DeTai(MaDT))");

  
            System.out.println("Đang chèn dữ liệu...");
            
            stmt.executeUpdate("INSERT INTO HocVi VALUES ('HV01', 'Thac Si'), ('HV02', 'Tien Si')");
            stmt.executeUpdate("INSERT INTO SinhVien VALUES ('SV01', 'Truong Anh Tuan', 'Dong Thap', 'CNTT01'), ('SV02', 'Nguyen Quoc Tanh', 'Vinh Long', 'CNTT02')");
            stmt.executeUpdate("INSERT INTO DeTai VALUES ('DT01', 'Quan Ly So Tiet Kiem'), ('DT02', 'Nhan Dien Khuon Mat Hoc Bang Lai Xe')");
            stmt.executeUpdate("INSERT INTO GiaoVien VALUES ('GV01', 'Thay Vo Van Phuc', 'Vinh Long', 'HV02'), ('GV02', 'Co Bui Thi Diem Trinh', 'Can Tho', 'HV01')");

            stmt.executeUpdate("INSERT INTO SinhVien_DeTai VALUES ('SV01', 'DT01'), ('SV02', 'DT02')");
            stmt.executeUpdate("INSERT INTO GiaoVien_DeTai VALUES ('GV01', 'DT01'), ('GV02', 'DT02')");

            stmt.executeUpdate("INSERT INTO KetQua VALUES ('SV01', 'DT01', 8.5), ('SV02', 'DT02', 9.0)");

            System.out.println("=== HOÀN TẤT SETUP BÀI 4 ===");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}