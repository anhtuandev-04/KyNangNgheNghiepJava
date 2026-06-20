//Trương Anh Tuấn - 220616
package module2.buoi2;

import java.util.Scanner;
public class GiaiPTBac1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap he so thu nhat: ");
		double b = sc.nextDouble();
		System.out.print("Nhap he so thu hai: ");
		double c = sc.nextDouble();
		
		if(b == 0 && c == 0) {
			
			System.out.println("Phuong trinh vo so nghiem");
		} else if(b == 0 && c !=0 ) {
			System.out.println("Phuong trinh vo nghiem");
		} else {
			double x = -c/b;
			System.out.println("Phuong trinh co nghiem x = "+x);
		}
	}

}