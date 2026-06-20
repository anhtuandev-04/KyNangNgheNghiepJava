//Trương Anh Tuấn 220616
package module3.buoi3.tinhtongdayso;
import java.util.Scanner;

public class TinhTong {
	private int n;
	
	public TinhTong() {
		this.n = 0;
	}
	
	public TinhTong(int n) {
		if(n>0) {
			this.n = n;
		}else {
			this.n = 0;
		}
	}
	
	public void setN(int n) {
		if(n>0) {
			this.n = n;
		} else {
			System.out.println("n phải là số nguyên dương!!!");
		}
	}
	
	public int getN() {
		return this.n;
	}
	
	public void nhapN(Scanner scanner) {
		int bientam;
		
		do {
			System.out.println("Nhập vào số nguyên dương n: ");
			if(scanner.hasNextInt()){
				bientam = scanner.nextInt();
				if(bientam > 0) {
					this.n = bientam;
					break;
				} else {
					System.out.println("n phải lớn hơn 0. Nhập lại!!!");
				}
			} else {
				System.out.println("Không hợp lệ, hãy nhập lại!");
				scanner.next();
				bientam = 0;
			}
		} while (bientam <= 0); 
		scanner.nextLine();
	}
	
	public long tinhTong() {
		if (this.n <= 0) {
			return 0;
		}
		
		long tong = 0;
        for (int i = 1; i <= this.n; i++) {
            tong += i;
        }
        return tong;
	}
}