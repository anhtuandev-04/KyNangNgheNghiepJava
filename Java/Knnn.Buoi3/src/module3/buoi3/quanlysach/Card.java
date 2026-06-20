//Trương Anh Tuấn 220616
package module3.buoi3.quanlysach;
import java.util.Scanner;

public class Card {
	private String tuaSach;
	private String tacGia;
	private int soLuong;
	
	public Card() {
		this.tuaSach = "";
		this.tacGia = "";
		this.soLuong = 0;
	}
	
	public Card(String tuaSach, String tacGia, int soLuong) {
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.soLuong = soLuong;
	}

	public int getSoLuong() {
		return soLuong;
	}
	
	public void nhapThongTin(Scanner scanner) {
		System.out.println("Nhập tựa đề sách: ");
		this.tuaSach = scanner.nextLine();
		System.out.println("Nhập tác giả: ");
		this.tacGia = scanner.nextLine();
		System.out.println("Nhập số lượng sách: ");
		
		if(scanner.hasNextInt()) {
			this.soLuong = scanner.nextInt();
		} else {
			this.soLuong = 0;
			System.out.println("Số lượng không hợp lệ!!!");
		}
		scanner.nextLine();
	}
	
	public void xuatThongTin() {
		System.out.printf("|  %-25s  |  %-20s  |  %-10d  |%n", this.tuaSach, this.tacGia, this.soLuong);
	}
	
}