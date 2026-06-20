package Proccess;

import java.sql.*;
import Database.Connect;

public class DanhMucDAL {
    Connect cn = new Connect();

    public ResultSet getAll() {
        return cn.LoadData("SELECT * FROM DanhMuc");
    }

    public void insert(String ma, String ten) {
        String sql = "INSERT INTO DanhMuc VALUES('" + ma + "', '" + ten + "')";
        cn.UpdateData(sql);
    }

    public void update(String ma, String ten) {
        String sql = "UPDATE DanhMuc SET TenDM='" + ten + "' WHERE MaDM='" + ma + "'";
        cn.UpdateData(sql);
    }

    public void delete(String ma) {
        cn.UpdateData("DELETE FROM DanhMuc WHERE MaDM='" + ma + "'");
    }

    // Kiểm tra xem danh mục này có sản phẩm con hay không
    public boolean hasProducts(String maDM) throws SQLException {
        ResultSet rs = cn.LoadData("SELECT COUNT(*) FROM SanPham WHERE MaDM='" + maDM + "'");
        if (rs != null && rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }
    
    // Xóa tất cả sản phẩm thuộc danh mục
    public void deleteAllProductsInDM(String maDM) {
        cn.UpdateData("DELETE FROM SanPham WHERE MaDM='" + maDM + "'");
    }
}