//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;

public class Bai8ViTriSNT {
	public static boolean laNguyenTo(int n) {
	        if (n < 2) return false;
	        for (int i = 2; i <= Math.sqrt(n); i++)
	            if (n % i == 0) return false;
	        return true;
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

	        int tong = 0;
	        System.out.print("Vị trí các số nguyên tố: ");
	        boolean co = false;
	        for (int i = 0; i < n; i++) {
	            if (laNguyenTo(a[i])) {
	                System.out.print(i + " ");
	                tong += a[i];
	                co = true;
	            }
	        }
	        if (!co) System.out.print("Không có số nguyên tố nào.");
	        System.out.println("\nTổng các số nguyên tố: " + tong);
	    }
	}


