//Trương Anh Tuấn - 220616
package module2.buoi2;

import java.util.Scanner;

public class NhapXuatMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		Scanner input = new Scanner (System. in) ;
		System.out.println("Nhập vào kích thước mảng: ");
		int n = input.nextInt();
		int [] Array1Chieu = new int [n];
		for (int i=0; i<n; i++){
			System. out.println("Nhập vào phần tử thứ "+(i+1)+" mảng: ");
			Array1Chieu [i] = input.nextInt();
		}
		System.out.print ("Mảng nhập vào là: ");
		for (int i=0; i<n; i++){
			System. out.print (Array1Chieu[i]+" ");
		}
	}
}