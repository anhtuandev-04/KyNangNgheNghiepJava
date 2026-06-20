//Trương Anh Tuấn 220616
package module3.buoi1.quanlyhinhhoc;

import java.util.Scanner;
public class TamGiac {
    private Diem d1, d2, d3;
    public TamGiac() {
        d1 = new Diem();
        d2 = new Diem();
        d3 = new Diem();}
    public TamGiac(Diem d1, Diem d2, Diem d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;}
    public void nhapTamGiac(Scanner sc) {
        System.out.println("Nhập điểm thứ nhất:");
        d1 = new Diem();
        d1.nhapDiem(sc);
        System.out.println("Nhập điểm thứ hai:");
        d2 = new Diem();
        d2.nhapDiem(sc);
        System.out.println("Nhập điểm thứ ba:");
        d3 = new Diem();
        d3.nhapDiem(sc);}
    public void xuatTamGiac() {
        System.out.print("Đỉnh 1: ");
        d1.xuatDiem();
        System.out.print("Đỉnh 2: ");
        d2.xuatDiem();
        System.out.print("Đỉnh 3: ");
        d3.xuatDiem();
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Diện tích: " + tinhDienTich());}
    public double canhA() { return d1.khoangCach(d2); }
    public double canhB() { return d2.khoangCach(d3); }
    public double canhC() { return d1.khoangCach(d3); }
    public double tinhChuVi() {
        return canhA() + canhB() + canhC();}
    public double tinhDienTich() {
        double a = canhA();
        double b = canhB();
        double c = canhC();
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
