//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;
public class Bai2TimGTDuong {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextDouble();
        }

        Double firstPositive = null;
        for (double x : a) {
            if (x > 0) {
                firstPositive = x;
                break;
            }
        }

        if (firstPositive != null)
            System.out.println("Giá trị dương đầu tiên: " + firstPositive);
        else
            System.out.println("Không có số dương trong mảng.");
    }
}
