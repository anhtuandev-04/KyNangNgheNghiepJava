//Trương Anh Tuấn 220616
package module3.buoi3.mang1chieu;
import java.util.Scanner;

public class TestMang1Chieu {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*CHƯƠNG TRÌNH QUẢN LÝ MẢNG ! CHIỀU*");

        Mang1Chieu myArr = new Mang1Chieu();
        myArr.nhapMang(scanner);
        
        System.out.println("\n========================================");
        
        System.out.print("1. ");
        myArr.inMang();
        
        System.out.println("\n2. Kết quả Max/Min:");
        myArr.inMaxMin();
        
        System.out.println("\n3. Tổng các phần tử: " + myArr.tinhTong());
        
        myArr.sapXepTangDan();
        System.out.println("\n4. Mảng sau khi sắp xếp TĂNG DẦN:");
        myArr.inMang();

        myArr.sapXepGiamDan();
        System.out.println("\n5. Mảng sau khi sắp xếp GIẢM DẦN:");
        myArr.inMang();

        System.out.println("========================================");
        
        scanner.close();
    }
}
