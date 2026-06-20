//Trương Anh Tuấn 220616
package module3.buoi3.quanlythisinh;
import java.util.Scanner;

public class TestThiSinh {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n;

	        System.out.println("*CHƯƠNG TRÌNH QUẢN LÝ THÍ SINH*");
	        System.out.print("Nhập số lượng thí sinh (n): ");
	        
	        if (scanner.hasNextInt()) {
	            n = scanner.nextInt();
	        } else {
	            n = 0;
	        }
	        scanner.nextLine();

	        if (n <= 0) {
	            System.out.println("Kết thúc chương trình.");
	            scanner.close();
	            return;
	        }

	        ThiSinh[] danhSachTS = new ThiSinh[n];

	        System.out.println("\nNHẬP THÔNG TIN CHO " + n + " THÍ SINH ---");
	        for (int i = 0; i < n; i++) {
	            System.out.println("\nNhập thông tin thí sinh thứ " + (i + 1) + ":");
	            danhSachTS[i] = new ThiSinh();
	            danhSachTS[i].nhapThongTin(scanner);
	        }

	        System.out.println("\nDANH SÁCH THÍ SINH");
	        inBang(danhSachTS);
	        inThiSinhDiemCaoNhat(danhSachTS);
	        scanner.close();
	    }
	    
	    public static void inBang(ThiSinh[] danhSachTS) {
	        System.out.println("---------------------------------------------------------------------------------");
	        System.out.printf("| %-12s | %-20s | %-20s | %-8s | %-8s | %-8s | %-8s |%n", 
	                          "SBD", "HỌ TÊN", "ĐỊA CHỈ", "TOÁN", "LÝ", "HÓA", "TỔNG ĐIỂM");
	        System.out.println("---------------------------------------------------------------------------------");
	        for (ThiSinh ts : danhSachTS) {
	            ts.xuatThongTin();
	        }
	        System.out.println("---------------------------------------------------------------------------------");
	    }

	    public static void inThiSinhDiemCaoNhat(ThiSinh[] danhSachTS) {
	        if (danhSachTS.length == 0) return;

	        double maxDiem = danhSachTS[0].tinhDiemTong();

	        for (int i = 1; i < danhSachTS.length; i++) {
	            if (danhSachTS[i].tinhDiemTong() > maxDiem) {
	                maxDiem = danhSachTS[i].tinhDiemTong();
	            }
	        }

	        System.out.println("\nTHÍ SINH CÓ ĐIỂM CAO NHẤT (Điểm: " + String.format("%.2f", maxDiem) + ")");
	        System.out.println("---------------------------------------------------------------------------------");
	        System.out.printf("| %-12s | %-20s | %-20s | %-8s | %-8s | %-8s | %-8s |%n", 
	                          "SBD", "HỌ TÊN", "ĐỊA CHỈ", "TOÁN", "LÝ", "HÓA", "TỔNG ĐIỂM");
	        System.out.println("---------------------------------------------------------------------------------");
	        
	        for (ThiSinh ts : danhSachTS) {
	            if (ts.tinhDiemTong() == maxDiem) {
	                ts.xuatThongTin();
	            }
	        }
	        System.out.println("---------------------------------------------------------------------------------");
	    }
	}