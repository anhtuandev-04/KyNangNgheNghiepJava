//Trương Anh Tuấn 220616
package module3.buoi3.tinhtongdayso;
import java.util.Scanner;

public class TestTinhTong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        TinhTong tongDaySo = new TinhTong();
        System.out.println("*CHƯƠNG TRÌNH TÍNH TỔNG S = 1 + 2 + ... + n*");

        tongDaySo.nhapN(scanner);
        
        long ketQua = tongDaySo.tinhTong();
        
        System.out.println("\n------------------------------------------------");
        System.out.println("Bạn đã nhập n = " + tongDaySo.getN());
        System.out.println("Giá trị tổng S = 1 + 2 + ... + " + tongDaySo.getN() + " là: " + ketQua);
        System.out.println("------------------------------------------------");

        scanner.close();
    }
}
