//Trương Anh Tuấn 220616
package module3.buoi2.quanlythongtinsinhvien;
import java.util.Scanner;
public class TestMangSinhVien {

	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      SinhVien sv = new SinhVien(); 
      int n;
      do {
      	System.out.print("**Số lượng sinh viên cần nhập thông tin: ");
      	n = sc.nextInt();
      }while(n <= 0 || n >= 100);
      SinhVien[] ds = new SinhVien[n];
      System.out.println("\n*Nhập thông tin sinh viên*");
      for(int i = 0; i < n; i++) {
      	System.out.println("\nSinh viên thứ " + (i + 1) + ": ");
      	ds[i] = new SinhVien();
      	ds[i].Nhap();
      }
      System.out.println("\n*Thông tin sinh viên*");
      System.out.printf("%-15s %-25s %15s %15s %18s%n",
          "Mã số sinh viên", "Họ tên", "Điểm lý thuyết", "Điểm thực hành", "Điểm trung bình");
      
      for (int i = 0 ; i < n; i++) {
      	ds[i].In();
      }
	
	}

}