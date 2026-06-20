//Trương Anh Tuấn 220616
package module3.buoi1.quanlyhinhhoc;

import java.util.Scanner;
public class HinhTron {
    private Diem tam;  
    private int r;      
    public HinhTron() {
        tam = new Diem(0, 0);
        r = 0;}
    public HinhTron(Diem tam, int r) {
        this.tam = tam;
        this.r = r;}
    public Diem getTam() {
        return tam;}
    public void setTam(Diem tam) {
        this.tam = tam;}
    public int getR() {
        return r;}
    public void setR(int r) {
        this.r = r;}
    public void nhapHinhTron(Scanner sc) {
        System.out.println("Nhập tâm hình tròn");
        tam = new Diem();
        tam.nhapDiem(sc);
        System.out.print("Nhập bán kính: ");
        r = sc.nextInt();
    }
    public void xuatHinhTron() {
        System.out.print("Tâm: ");
        tam.xuatDiem();
        System.out.println("Bán kính: " + r);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Diện tích: " + tinhDienTich());
    }
    public double tinhChuVi() {
        return 2 * Math.PI * r;
    }
    public double tinhDienTich() {
        return Math.PI * r * r;
    }
}
