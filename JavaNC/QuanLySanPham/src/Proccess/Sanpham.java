package Proccess;
import Database.Connect;
import java.sql.*;

public class Sanpham {
    public Connect cn = new Connect();

    // 1. Truy vấn tất cả dữ liệu trong Table LoaiSP
    public ResultSet ShowLoaiSP() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM LoaiSP";
        return cn.LoadData(sql);
    }

    // 2. Truy vấn dữ liệu trong Table LoaiSP theo Maloai
    public ResultSet ShowLoaiSP(String ml) throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM LoaiSP WHERE Maloai='" + ml + "'";
        return cn.LoadData(sql);
    }

    // 3. Truy vấn sản phẩm theo Maloai (kèm tên loại)
    public ResultSet ShowSPTheoloai(String ml) throws SQLException { // <--- Thêm vào đây
        cn.connectSQL();
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai " +
                     "FROM Sanpham S, LoaiSP L " +
                     "WHERE L.Maloai = S.Maloai AND L.Maloai='" + ml + "'";         
        return cn.LoadData(sql); 
    }

    // 4. Truy vấn tất cả dữ liệu trong Table Sanpham (kết hợp bảng LoaiSP)
    public ResultSet ShowSanpham() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai " +
                     "FROM Sanpham S, LoaiSP L " +
                     "WHERE L.Maloai = S.Maloai";
        return cn.LoadData(sql);
    }

    // 5. Truy vấn dữ liệu trong Table Sanpham theo MaSP
    public ResultSet ShowSPTheoma(String ma) throws SQLException {
        cn.connectSQL();
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai " +
                     "FROM Sanpham S, LoaiSP L " +
                     "WHERE L.Maloai = S.Maloai AND MaSP='" + ma + "'";
        return cn.LoadData(sql);
    }

    // 6. Truy vấn dữ liệu trong Table Sanpham theo giá (từ... đến...)
    public ResultSet ShowSPTheogia(int giatu, int giaden) throws SQLException {
        cn.connectSQL();
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai " +
                     "FROM Sanpham S, LoaiSP L " +
                     "WHERE L.Maloai = S.Maloai AND Dongia BETWEEN " + giatu + " AND " + giaden;
        return cn.LoadData(sql);
    }

    // 7. Truy vấn dữ liệu trong Table Sanpham theo tên (Tìm kiếm gần đúng)
    public ResultSet ShowSPTheoten(String ten) throws SQLException {
        cn.connectSQL();
        // MySQL sử dụng LIKE '%tên%' để tìm kiếm chứa chuỗi
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai " +
                     "FROM Sanpham S, LoaiSP L " +
                     "WHERE L.Maloai = S.Maloai AND TenSP LIKE '%" + ten + "%'";
        return cn.LoadData(sql);
    }

    // 8. Thêm mới 1 dòng dữ liệu vào table Sanpham
    public void InsertSanpham(String ma, String ten, int dg, String ml) throws SQLException {
        cn.connectSQL();
        // Đã bỏ chữ N trước các tham số chuỗi cho MySQL
        String sql = "INSERT INTO Sanpham VALUES('" + ma + "','" + ten + "'," + dg + ",'" + ml + "')";
        cn.UpdateData(sql);
    }

    // 9. Điều chỉnh (Sửa) 1 dòng dữ liệu trong table Sanpham
    public void EditSanpham(String ma, String ten, int dg, String ml) throws SQLException {
        cn.connectSQL();
        // Cập nhật thông tin dựa trên MaSP
        String sql = "UPDATE Sanpham SET TenSP='" + ten + "', Dongia=" + dg + ", Maloai='" + ml + "' " +
                     "WHERE MaSP='" + ma + "'";
        cn.UpdateData(sql);
    }

    // 10. Xóa 1 dòng dữ liệu trong table Sanpham theo MaSP
    public void DeleteSanpham(String ma) throws SQLException {
        cn.connectSQL();
        String sql = "DELETE FROM Sanpham WHERE MaSP='" + ma + "'";
        cn.UpdateData(sql);
    }
}