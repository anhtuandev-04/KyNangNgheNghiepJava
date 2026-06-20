package Proccess;

import Database.Connect;
import java.sql.*;

public class SinhVienDAL {
    public Connect cn = new Connect();

    public ResultSet getByLop(String msLop) throws SQLException {
        cn.connectSQL();
        return cn.LoadData("SELECT * FROM Sinhvien WHERE msLop='" + msLop + "'");
    }

    public void insert(String ms, String ten, String email, String dc, String ml) throws SQLException {
        cn.connectSQL();
        String sql = "INSERT INTO Sinhvien VALUES('" + ms + "','" + ten + "','" + email + "','" + 
        dc + "','" + ml + "')";
        cn.UpdateData(sql);
    }

    public void update(String ms, String ten, String email, String dc, String ml) throws SQLException {
        cn.connectSQL();
        String sql = "UPDATE Sinhvien SET hoTen='" + ten + "', email='" + email + "', "
        		+ "diaChi='" + dc + "' WHERE msSV='" + ms + "'";
        cn.UpdateData(sql);
    }

    public void delete(String ms) throws SQLException {
        cn.connectSQL();
        cn.UpdateData("DELETE FROM Sinhvien WHERE msSV='" + ms + "'");
    }
}