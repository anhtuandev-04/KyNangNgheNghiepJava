//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;

public class Bai6TimGTDNN {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        Integer minPos = null;
        for (int x : a) {
            if (x > 0) {
                if (minPos == null || x < minPos) minPos = x;
            }
        }

        if (minPos != null)
            System.out.println("Giá trị dương nhỏ nhất: " + minPos);
        else
            System.out.println("Không có số dương trong mảng.");
    }
}
