package Proccess;
import java.sql.*;
import Database.Connect;

public class SanPhamDAL {
    Connect cn = new Connect();

    public ResultSet getAll() {
        return cn.LoadData("SELECT * FROM SanPham");
    }

    // Lấy sản phẩm theo mã danh mục
    public ResultSet getByDanhMuc(String maDM) {
        return cn.LoadData("SELECT * FROM SanPham WHERE MaDM='" + maDM + "'");
    }
    
    // Kiểm tra mã sản phẩm tồn tại
    public boolean exists(String maSP) throws SQLException {
        ResultSet rs = cn.LoadData("SELECT * FROM SanPham WHERE MaSP='" + maSP + "'");
        return rs != null && rs.next();
    }

    // Thêm mới sản phẩm 
    public void insert(String ma, String ten, double gia, int sl, String maDM, String mota) {
        String sql = "INSERT INTO SanPham VALUES('" + ma + "','" + ten + "'," + gia + "," + sl + ",'" + maDM + "', '" + mota + "')";
        cn.UpdateData(sql);
    }

    // Cập nhật sản phẩm 
    public void update(String ma, String ten, double gia, int sl, String maDM, String mota) {
        String sql = "UPDATE SanPham SET TenSP='" + ten + "', DonGia=" + gia + ", SoLuong=" + sl + ", MaDM='" + maDM + "', MoTa='" + mota + "' WHERE MaSP='" + ma + "'";
        cn.UpdateData(sql);
    }

    // Xóa sản phẩm
    public void delete(String ma) {
        cn.UpdateData("DELETE FROM SanPham WHERE MaSP='" + ma + "'");
    }
}