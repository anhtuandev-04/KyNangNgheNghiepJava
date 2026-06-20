package BaiTapGUIb4;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private final String masv;
    private String hoten, malop;
    private double diemLT, diemTH;

    public SinhVien(String masv, String hoten, String malop, double diemLT, double diemTH) throws Exception {
        this.masv = masv;
        this.hoten = hoten;
        this.malop = malop;
        setDiemLT(diemLT); 
        setDiemTH(diemTH);
    }

    public SinhVien(String masv) throws Exception {
        this(masv, "Chưa nhập", "NCTH6A", 0.0, 0.0);
    }

    public String getMasv() { return masv; }
    public String getHoten() { return hoten; }
    public void setHoten(String hoten) { this.hoten = hoten; }
    public String getMalop() { return malop; }
    public void setMalop(String malop) { this.malop = malop; }
    public double getDiemLT() { return diemLT; }

    public void setDiemLT(double diemLT) throws Exception {
        if (diemLT < 0 || diemLT > 10) throw new Exception("Điểm lý thuyết từ 0-10");
        this.diemLT = diemLT;
    }

    public double getDiemTH() { return diemTH; }

    public void setDiemTH(double diemTH) throws Exception {
        if (diemTH < 0 || diemTH > 10) throw new Exception("Điểm thực hành từ 0-10");
        this.diemTH = diemTH;
    }

    public double diemTB() { return (diemLT + diemTH) / 2; }
    public String ketQua() { return (diemTB() >= 5) ? "Đậu" : "Rớt"; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SinhVien) {
            return this.masv.equalsIgnoreCase(((SinhVien) obj).masv);
        }
        return false;
    }
}