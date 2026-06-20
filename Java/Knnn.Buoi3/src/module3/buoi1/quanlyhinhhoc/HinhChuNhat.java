//Trương Anh Tuấn 220616
package module3.buoi1.quanlyhinhhoc;

public class HinhChuNhat {
    
    private double dai;
    private double rong;
    
    public HinhChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }
    
    public HinhChuNhat() {}
    
    public double getDai() {
        return dai;
    }

    public double getRong() {
        return rong;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }

    public void setRong(double rong) {
        this.rong = rong;
    }
    
    public double tinhDienTich() {
        return dai * rong;
    }

    public double tinhChuVi() {
        return (dai + rong) * 2;
    }
}
