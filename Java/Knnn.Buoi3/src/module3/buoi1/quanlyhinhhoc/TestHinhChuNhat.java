//Trương Anh Tuấn 220616
package module3.buoi1.quanlyhinhhoc;

import java.util.Scanner;

public class TestHinhChuNhat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HinhChuNhat hcn = new HinhChuNhat();
        
        System.out.println("*CHU VI/DIỆN TÍCH HCN*");
        
        System.out.print("Nhập chiều dài hcn: ");
        hcn.setDai(scanner.nextDouble());
        
        System.out.print("Nhập chiều rộng hcn: ");
        hcn.setRong(scanner.nextDouble());
        
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.printf("Chiều dài: %.2f%n", hcn.getDai());
        System.out.printf("Chiều rộng: %.2f%n", hcn.getRong());
        System.out.printf("Chu vi hcn là: %.2f%n", hcn.tinhChuVi());
        System.out.printf("Diện tích hcn là: %.2f%n", hcn.tinhDienTich());
        
        scanner.close();
    }
}