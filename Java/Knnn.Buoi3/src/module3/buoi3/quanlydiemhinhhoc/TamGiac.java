//Trương Anh Tuấn 220616
package module3.buoi3.quanlydiemhinhhoc;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class TamGiac {
    private Diem d1; 
    private Diem d2; 
    private Diem d3; 

    public TamGiac() {
        this.d1 = new Diem();
        this.d2 = new Diem();
        this.d3 = new Diem();
    }

    public TamGiac(Diem d1, Diem d2, Diem d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public void nhapTamGiac(Scanner scanner) {
        System.out.println("Nhập tọa độ d1:");
        this.d1.nhapToaDo(scanner);
        System.out.println("Nhập tọa độ d2:");
        this.d2.nhapToaDo(scanner);
        System.out.println("Nhập tọa độ d3:");
        this.d3.nhapToaDo(scanner);
        scanner.nextLine();
    }

    public void xuatTamGiac() {
        System.out.print("Tam giác có 3 đỉnh: d1");
        this.d1.xuatToaDo();
        System.out.print(", d2");
        this.d2.xuatToaDo();
        System.out.print(", d3");
        this.d3.xuatToaDo();
        System.out.println();
    }
    
    private double tinhCanhA() { 
        return d1.tinhKhoangCach(d2);
    }

    private double tinhCanhB() { 
        return d2.tinhKhoangCach(d3);
    }
    
    private double tinhCanhC() {
        return d1.tinhKhoangCach(d3);
    }

    public double tinhChuVi() {
        double a = tinhCanhA();
        double b = tinhCanhB();
        double c = tinhCanhC();
       
        if (a + b > c && a + c > b && b + c > a) {
            return a + b + c;
        } else {
            return 0.0;
        }
    }

    public double tinhDienTich() {
        double chuVi = tinhChuVi();
        if (chuVi == 0.0) {
            return 0.0;
        }
        
        double a = tinhCanhA();
        double b = tinhCanhB();
        double c = tinhCanhC();

        double p = chuVi / 2.0;

        double dienTichBinhPhuong = p * (p - a) * (p - b) * (p - c);
        return sqrt(dienTichBinhPhuong);
    }
}
