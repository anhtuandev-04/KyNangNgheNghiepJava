//Trương Anh Tuấn 220616
package module3.buoi3.quanlysach;
import java.util.Scanner;

public class TestCard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("*CHƯƠNG TRÌNH QUẢN LÝ SÁCH*");
        System.out.print("Nhập số lượng sách (n) cần nhập: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            n = 0;
            System.out.println("(!) số lượng không hợp lệ, gần n = 0.");
        }
        scanner.nextLine(); 

        if (n <= 0) {
            System.out.println("kết thúc chương trình, số lượng không hợp lệ.");
            scanner.close();
            return;
        }

        Card[] danhSachSach = new Card[n];

        System.out.println("\n*NHẬP THÔNG TIN " + n + " CUỐN SÁCH *");
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sách thứ " + (i + 1) + ":");
            danhSachSach[i] = new Card(); 
            danhSachSach[i].nhapThongTin(scanner); 
        }

        System.out.println("\n\n* THÔNG TIN " + n + " CUỐN SÁCH *");
        inBang(danhSachSach);

        inSachSoLuongLonNhat(danhSachSach);
        
        scanner.close();
    }
    
    public static void inBang(Card[] danhSachSach) {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("| %-25s | %-20s | %-10s |%n", "TỰA ĐỀ SÁCH", "TÁC GIẢ", "SỐ LƯỢNG");
        System.out.println("------------------------------------------------------------------");
        for (Card sach : danhSachSach) {
            sach.xuatThongTin();
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void inSachSoLuongLonNhat(Card[] danhSachSach) {
        if (danhSachSach.length == 0) return;

        int maxQuantity = danhSachSach[0].getSoLuong();
        for (int i = 1; i < danhSachSach.length; i++) {
            if (danhSachSach[i].getSoLuong() > maxQuantity) {
                maxQuantity = danhSachSach[i].getSoLuong();
            }
        }

        System.out.println("\nSÁCH CÓ SỐ LƯỢNG LỚN NHẤT (So luong: " + maxQuantity + ")");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("| %-25s | %-20s | %-10s |%n", "TỰA ĐỀ SÁCH", "TÁC GIẢ", "SỐ LƯỢNG");
        System.out.println("------------------------------------------------------------------");
        
        for (Card sach : danhSachSach) {
            if (sach.getSoLuong() == maxQuantity) {
                sach.xuatThongTin();
            }
        }
        System.out.println("------------------------------------------------------------------");
    }
}