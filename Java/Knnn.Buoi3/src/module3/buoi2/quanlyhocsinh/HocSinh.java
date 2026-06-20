//Trương Anh Tuấn 220616
package module3.buoi2.quanlyhocsinh;
import java.util.Scanner;

public class HocSinh {
    private String ma;
    private String hoTen;
    private double diemHK1;
    private double diemHK2;

    public HocSinh() {
    }

    public HocSinh(String ma, String hoTen, double diemHK1, double diemHK2) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.diemHK1 = diemHK1;
        this.diemHK2 = diemHK2;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã học sinh: ");
        ma = sc.nextLine();

        System.out.print("Nhập họ tên: ");
        hoTen = sc.nextLine();

        System.out.print("Nhập điểm HK1: ");
        diemHK1 = sc.nextDouble();

        System.out.print("Nhập điểm HK2: ");
        diemHK2 = sc.nextDouble();
    }

    public double tinhDTB() {
        return (diemHK1 + diemHK2) / 2;
    }

    public String xepLoai() {
        double tb = tinhDTB();
        if (tb < 3) return "Kém";
        else if (tb < 5) return "Yếu";
        else if (tb < 6.5) return "Trung bình";
        else if (tb < 7) return "Trung bình khá";
        else if (tb < 8) return "Khá";
        else if (tb < 9) return "Giỏi";
        else return "Xuất sắc";
    }

    public void xuat() {
        System.out.printf("%-10s %-20s %10.2f %10.2f %10.2f %-15s\n",
                ma, hoTen, diemHK1, diemHK2, tinhDTB(), xepLoai());
    }

    public double getDTB() {
        return tinhDTB();
    }
}