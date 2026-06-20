//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;

public class Bai7SoChinhPhuong {
	public static boolean laSoChinhPhuong(int n) {
        if (n < 0) return false;
        int can = (int) Math.sqrt(n);
        return can * can == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        System.out.print("Vị trí các số chính phương: ");
        boolean co = false;
        for (int i = 0; i < n; i++) {
            if (laSoChinhPhuong(a[i])) {
                System.out.print(i + " ");
                co = true;
            }
        }
        if (!co) System.out.print("Không có số chính phương nào.");
    }
}
