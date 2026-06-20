package Proccess;

import Database.Connect;
import java.sql.*;

public class LopHoc {
    public Connect cn = new Connect();

    public ResultSet ShowLopHoc() throws SQLException {
        cn.connectSQL();
        return cn.LoadData("SELECT * FROM LopHoc");
    }

    public void InsertLop(String ms, String ten, String gv) throws SQLException {
        cn.connectSQL();
        String sql = "INSERT INTO LopHoc VALUES('" + ms + "','" + ten + "','" + gv + "')";
        cn.UpdateData(sql);
    }
    // Tương tự cho Update và Delete...
}