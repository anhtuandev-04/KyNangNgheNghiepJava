package Proccess;

import Database.Connect;
import java.sql.*;

public class SinhVien {
    public Connect cn = new Connect();

    public ResultSet ShowSinhVien() throws SQLException {
        cn.connectSQL();
        // Lấy thông tin SV kèm tên lớp để hiển thị lên JTable
        String sql = "SELECT s.msSV, s.hoTen, s.email, s.diaChi, l.tenLop FROM Sinhvien s, LopHoc l WHERE s.msLop = l.msLop";
        return cn.LoadData(sql);
    }

    public void InsertSV(String ms, String ten, String email, String dc, String mlop) throws SQLException {
        cn.connectSQL();
        String sql = "INSERT INTO Sinhvien VALUES('" + ms + "','" + ten + "','" + email + "','" + dc + "','" + mlop + "')";
        cn.UpdateData(sql);
    }
}