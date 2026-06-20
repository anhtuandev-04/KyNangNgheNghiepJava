//Trương Anh Tuấn 220616
package module3.buoi1.quanlyhinhhoc;

import java.util.Scanner;

public class Diem {
    private int x;
    private int y;
    public Diem() {
        this.x = 0;
        this.y = 0;
    }
    public Diem(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void nhapDiem(Scanner sc) {
        System.out.print("Nhập hoành độ x: ");
        this.x = sc.nextInt();
        System.out.print("Nhập tung độ y: ");
        this.y = sc.nextInt();
    }
    public void xuatDiem() {
        System.out.println("(" + x + ", " + y + ")");
    }
    public double khoangCach(Diem d2) {
        return Math.sqrt(Math.pow(d2.x - this.x, 2) + Math.pow(d2.y - this.y, 2));
    }
}