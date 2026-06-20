//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;
public class Bai3TimSoChanCuoiCung {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        Integer lastEven = null;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] % 2 == 0) {
                lastEven = a[i];
                break;
            }
        }

        if (lastEven != null)
            System.out.println("Số chẵn cuối cùng là: " + lastEven);
        else
            System.out.println("Không có số chẵn trong mảng.");
    }
}
