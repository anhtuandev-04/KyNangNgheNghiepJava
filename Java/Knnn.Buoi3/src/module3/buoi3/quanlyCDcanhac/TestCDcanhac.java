//Trương Anh Tuấn 220616
package module3.buoi3.quanlyCDcanhac;
import java.util.Scanner;

public class TestCDcanhac {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("*CHƯƠNG TRÌNH QUẢN LÝ CD CA NHẠC*");
        System.out.print("Nhập số lượng đĩa CD (n) cần nhập: ");
        
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            n = 0;
            System.out.println("(!) Số lượng CD không hợp lệ, gần n = 0.");
        }
        scanner.nextLine();

        if (n <= 0) {
            System.out.println("Kết thúc chương trình.");
            scanner.close();
            return;
        }

        CDcanhac[] danhSachCD = new CDcanhac[n];

        System.out.println("\nNhập thông tin cho " + n + " CD");
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin CD thứ " + (i + 1) + ":");
            danhSachCD[i] = new CDcanhac(); 
            danhSachCD[i].nhapThongTin(scanner); 
        }

        System.out.println("\nDANH SÁCH " + n + " CD VỪA NHẬP");
        inBang(danhSachCD);

        inCDSoLuongBaiLonNhat(danhSachCD);
        
        scanner.close();
    }
    
    public static void inBang(CDcanhac[] danhSachCD) {
        System.out.println("----------------------------------------------------------------");
        System.out.printf("| %-25s | %-15s | %-12s |%n", "TÊN ĐĨA", "SỐ LƯỢNG BÀI", "GIÁ TIỀN (VND)");
        System.out.println("----------------------------------------------------------------");
        for (CDcanhac cd : danhSachCD) {
            cd.xuatThongTin();
        }
        System.out.println("----------------------------------------------------------------");
    }

    public static void inCDSoLuongBaiLonNhat(CDcanhac[] danhSachCD) {
        if (danhSachCD.length == 0) return;

        int maxSongs = danhSachCD[0].getSoLuongBai();
        for (int i = 1; i < danhSachCD.length; i++) {
            if (danhSachCD[i].getSoLuongBai() > maxSongs) {
                maxSongs = danhSachCD[i].getSoLuongBai();
            }
        }

        System.out.println("\nĐĨA CD CÓ SỐ LƯỢNG BÀI LỚN NHẤT (Số lượng: " + maxSongs + ") ---");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("| %-25s | %-15s | %-12s |%n", "TÊN ĐĨA", "SỐ LƯỢNG BÀI", "GIÁ TIỀN (VND)");
        System.out.println("----------------------------------------------------------------");
        
        for (CDcanhac cd : danhSachCD) {
            if (cd.getSoLuongBai() == maxSongs) {
                cd.xuatThongTin();
            }
        }
        System.out.println("----------------------------------------------------------------");
    }
}