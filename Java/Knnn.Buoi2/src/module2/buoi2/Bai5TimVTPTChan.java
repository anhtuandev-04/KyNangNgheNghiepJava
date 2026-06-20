//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;

public class Bai5TimVTPTChan {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        int vt = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                vt = i;
                break;
            }
        }

        if (vt != -1)
            System.out.println("Phần tử chẵn đầu tiên ở vị trí: " + vt);
        else
            System.out.println("Không có phần tử chẵn trong mảng.");
    }
}
