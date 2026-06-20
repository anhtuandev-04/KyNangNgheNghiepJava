package BaiTapGUIb4;

import java.io.Serializable;

public class SanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    private String maSP;
    private String tenSP;
    private double donGia;
    private int soLuong;
    private String moTa;

    public SanPham(String maSP, String tenSP, double donGia, int soLuong, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }
    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SanPham) {
            return this.maSP.equalsIgnoreCase(((SanPham) obj).maSP);
        }
        return false;
    }
}