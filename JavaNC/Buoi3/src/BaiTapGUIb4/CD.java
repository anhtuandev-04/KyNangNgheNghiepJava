package BaiTapGUIb4;

import java.io.Serializable;

public class CD implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String maCD; // Không cho phép sửa sau khi khởi tạo
    private String tuaCD, caSy;
    private int soBaiHat;
    private double giaThanh;

    // Constructor đầy đủ tham số
    public CD(String maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }

    // Constructor có 1 tham số mã số CD
    public CD(String maCD) {
        this(maCD, "", "", 0, 0.0);
    }
    @Override
    public String toString() {
        return "Mã: " + maCD + " | Tựa: " + tuaCD + " | Ca sỹ: " + caSy + " | Bài: " + soBaiHat + " | Giá: " + giaThanh;
    }

    // Getters và Setters
    public String getMaCD() { return maCD; }
    public String getTuaCD() { return tuaCD; }
    public void setTuaCD(String tuaCD) { this.tuaCD = tuaCD; }
    public String getCaSy() { return caSy; }
    public void setCaSy(String caSy) { this.caSy = caSy; }
    public int getSoBaiHat() { return soBaiHat; }
    public void setSoBaiHat(int soBaiHat) { this.soBaiHat = soBaiHat; }
    public double getGiaThanh() { return giaThanh; }
    public void setGiaThanh(double giaThanh) { this.giaThanh = giaThanh; }

    // So sánh bằng theo mã số CD
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CD other = (CD) obj;
        return maCD.equalsIgnoreCase(other.maCD);
    }
}
