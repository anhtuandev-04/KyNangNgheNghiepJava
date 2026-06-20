//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;

public class Bai1TimGTLN_GTNN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        int min = a[0], max = a[0];
        for (int x : a) {
            if (x < min) min = x;
            if (x > max) max = x;
        }
        System.out.println("Giá trị nhỏ nhất: " + min);
        System.out.println("Giá trị lớn nhất: " + max);
    }
}