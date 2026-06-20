//Trương Anh Tuấn 220616
package module3.buoi3.quanlyCDcanhac;
import java.util.Scanner;

public class CDcanhac {
	private String tenDia;
	private int soLuongBai;
	private float giaTien;
	
	public CDcanhac() {
		this.tenDia = "";
		this.soLuongBai = 0;
		this.giaTien = 0.0f;
	}
	
	public void nhapThongTin(Scanner scanner) {
		System.out.println("Nhập tên đĩa: ");
		this.tenDia = scanner.nextLine();
		System.out.println("Nhập số bài nhạc: ");
		if(scanner.hasNextInt()) {
			this.soLuongBai = scanner.nextInt();
		} else {
			this.soLuongBai = 0;
			System.out.println("Số lượng bài không hợp lệ !!!");
		}
		
		System.out.println("Nhập giá: ");
		if(scanner.hasNextFloat()) {
			this.giaTien = scanner.nextFloat();
		} else {
			this.giaTien = 0.0f;
			System.out.println("Giá không hợp lệ mặc định = 0!!!");
		}
		scanner.nextLine();
	}
	
	public void xuatThongTin() {
		System.out.printf("| %-25s | %-15s | %-12.2f |%n", 
				this.tenDia, this.soLuongBai, this.giaTien);
	}
	
	public int getSoLuongBai() {
		return soLuongBai;
	}
}
