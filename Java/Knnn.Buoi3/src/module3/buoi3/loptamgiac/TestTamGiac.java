//Trương Anh Tuấn 220616
package module3.buoi3.loptamgiac;
import java.util.Scanner;

public class TestTamGiac {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		TamGiac tg = new TamGiac();
		
		
		TamGiac tg2 = new TamGiac(1,2,1);
		tg2.xuatTamGiac();
		if (!tg2.hopLe()) {
            System.out.println("Tam giác không hợp lệ");
        } else {
            System.out.println("Loại tam giác: " + tg2.phanLoai());
            System.out.println("Chu vi: " + tg2.chuVi());
            System.out.println("Diện tích: " + tg2.dienTich());
        }
		
		tg.nhapTamGiac(sc);
		tg.xuatTamGiac();
		
		if (!tg.hopLe()) {
            System.out.println("Tam giác không hợp lệ");
        } else {
            System.out.println("Loại tam giác: " + tg.phanLoai());
            System.out.println("Chu vi: " + tg.chuVi());
            System.out.println("Diện tích: " + tg.dienTich());
        }
	
	}

}