package Proccess;

import java.sql.*;
import Database.Connect;

public class BookDAL {
    Connect cn = new Connect();

    public ResultSet searchByPublisher(String keyword) {
        String sql = "SELECT * FROM tblBook WHERE PublisherCode LIKE '%" + keyword + "%'";
        return cn.LoadData(sql);
    }
}