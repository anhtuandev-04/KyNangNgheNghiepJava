package Proccess;

import java.sql.*;
import Database.Connect;

public class PublisherDAL {
    Connect cn = new Connect();

    public ResultSet getAll() {
        return cn.LoadData("SELECT * FROM tblPublisher");
    }

    public void insert(String code, String name, String addr, String phone) {
        String sql = "INSERT INTO tblPublisher VALUES('" + code + "','" + name + "','" + addr + "','" + phone + "')";
        cn.UpdateData(sql);
    }

    public void update(String code, String name, String addr, String phone) {
        String sql = "UPDATE tblPublisher SET PublisherName='" + name + "', Address='" + addr + "', Phone='" + phone + "' WHERE PublisherCode='" + code + "'";
        cn.UpdateData(sql);
    }

    public void delete(String code) {
        cn.UpdateData("DELETE FROM tblBook WHERE PublisherCode='" + code + "'");
        cn.UpdateData("DELETE FROM tblPublisher WHERE PublisherCode='" + code + "'");
    }
}