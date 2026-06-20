//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;

public class Bai4TimVTGTNN {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        int min = a[0], vt = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                vt = i;
            }
        }

        System.out.println("Giá trị nhỏ nhất đầu tiên ở vị trí: " + vt);
    }
}
