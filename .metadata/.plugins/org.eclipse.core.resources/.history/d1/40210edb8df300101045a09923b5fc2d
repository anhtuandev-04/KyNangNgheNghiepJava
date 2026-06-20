package Proccess;

import Database.Connect;
import java.sql.*;

public class LopHocDAL {
    public Connect cn = new Connect();

    public ResultSet getAll() throws SQLException {
        cn.connectSQL();
        return cn.LoadData("SELECT * FROM LopHoc");
    }

    public void insert(String ms, String ten, String gv) throws SQLException {
        cn.connectSQL();
        cn.UpdateData("INSERT INTO LopHoc VALUES('" + ms + "','" + ten + "','" + gv + "')");
    }

    public void update(String ms, String ten, String gv) throws SQLException {
        cn.connectSQL();
        cn.UpdateData("UPDATE LopHoc SET tenLop='" + ten + "', giavienCN='" + gv + "' WHERE msLop='" + ms + "'");
    }

    public void delete(String ms) throws SQLException {
        cn.connectSQL();
        cn.UpdateData("DELETE FROM LopHoc WHERE msLop='" + ms + "'");
    }
}