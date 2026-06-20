//Trương Anh Tuấn - 220616
package module2.buoi2;

import java.util.Scanner;
import java.util.Random;

public class MangNgauNhien {
	public static void main (String[] args) {
		int n; 
		int []a;
		Scanner sc = new Scanner (System. in) ;
		Random rd = new Random () ;
		do {
			System.out.print("Nhập số lượng phần tử mảng: n = ");
			n = sc.nextInt ();
		}while (n<=0 || n>=100);
		a = new int [n];
		for (int i = 0; i < n; i++) {
			a[i] = rd.nextInt (99)-1;
			System.out.print(a[i]+"\t");
		}
	}
}