//Trương Anh Tuấn 220616
package module3.buoi3.quanlydiemhinhhoc;
import java.util.Scanner;
public class TestHinhHoc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*KIỂM TRA ĐIỂM HÌNH HỌC*");

        Diem d1 = new Diem(1, 2);
        Diem d2 = new Diem();
        
        System.out.print("Điểm D1 khởi tạo (1, 2): "); d1.xuatToaDo(); System.out.println();
        
        System.out.println("Nhập tọa độ d2:");
        d2.nhapToaDo(scanner);
        
        System.out.print("Điểm d2 vừa nhập: "); d2.xuatToaDo(); System.out.println();
        
        double kc = d1.tinhKhoangCach(d2);
        System.out.printf("Khoảng cách d1 -> d2: %.4f%n", kc);

        System.out.println("\nKiểm tra lớp hình tròn");
        
        HinhTron ht = new HinhTron();
        ht.nhapHinhTron(scanner);
        ht.xuatHinhTron();
        
        System.out.printf("Chu vi hình tròn: %.4f%n", ht.tinhChuVi());
        System.out.printf("Diện tích hình tròn: %.4f%n", ht.tinhDienTich());

        System.out.println("\nKIỂM TRA TAM GIÁC");
        
        TamGiac tg = new TamGiac();
        tg.nhapTamGiac(scanner);
        tg.xuatTamGiac();
        
        double chuViTG = tg.tinhChuVi();
        double dienTichTG = tg.tinhDienTich();
        
        if (chuViTG > 0) {
            System.out.printf("Chu vi tam giác: %.4f%n", chuViTG);
            System.out.printf("Diện tích tam giác: %.4f%n", dienTichTG);
        } else {
            System.out.println("Ba điểm không tạo thành tam giác hợp lệ.");
        }
        
        scanner.close();
    }
}

