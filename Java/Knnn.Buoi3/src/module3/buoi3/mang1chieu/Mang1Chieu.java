//Trương Anh Tuấn 220616
package module3.buoi3.mang1chieu;
import java.util.Scanner;
import java.util.Arrays;

public class Mang1Chieu {
		private int soLuongPhanTu; 
	    private int[] a;          

	    public Mang1Chieu() {
	        this.soLuongPhanTu = 0;
	        this.a = new int[0];
	    }
	    

	    public void nhapMang(Scanner scanner) {
	        int n;
	        do {
	            System.out.print("Nhập số lượng phần tử: ");
	            if (scanner.hasNextInt()) {
	                n = scanner.nextInt();
	                if (n <= 0) {
	                    System.out.println("Số lượng phần tử lớn hơn 0. Nhập lại.");
	                }
	            } else {
	                System.out.println("Giá trị không hợp lệ. Nhập số nguyên.");
	                scanner.next(); 
	                n = 0;
	            }
	        } while (n <= 0);
	        
	        this.soLuongPhanTu = n;
	        this.a = new int[n];

	        System.out.println("Bắt đầu nhập các phần tử:");
	        for (int i = 0; i < n; i++) {
	            System.out.print("  Nhập phần tử thứ " + (i + 1) + ": ");
	            if (scanner.hasNextInt()) {
	                this.a[i] = scanner.nextInt();
	            } else {
	                System.out.println("Giá trị không hợp lệ, nên xét phần tử này = 0.");
	                this.a[i] = 0;
	                scanner.next(); 
	            }
	        }
	        scanner.nextLine(); 
	    }

	    public void inMang() {
	        if (soLuongPhanTu == 0) {
	            System.out.println("Mảng rỗng");
	            return;
	        }
	        System.out.print("Các phần tử của mảng: [");
	        for (int i = 0; i < soLuongPhanTu; i++) {
	            System.out.print(this.a[i] + (i < soLuongPhanTu - 1 ? ", " : ""));
	        }
	        System.out.println("]");
	    }

	    public void inMaxMin() {
	        if (soLuongPhanTu == 0) {
	            System.out.println("Không thể tìm Max/Min vì rỗng.");
	            return;
	        }
	        
	        int max = this.a[0];
	        int min = this.a[0];
	        
	        for (int i = 1; i < soLuongPhanTu; i++) {
	            if (this.a[i] > max) {
	                max = this.a[i];
	            }
	            if (this.a[i] < min) {
	                min = this.a[i];
	            }
	        }
	        
	        System.out.println("Phần tử lớn nhất: " + max);
	        System.out.println("Phần tử nhỏ nhất: " + min);
	    }

	    public long tinhTong() {
	        long tong = 0;
	        for (int phanTu : this.a) {
	            tong += phanTu;
	        }
	        return tong;
	    }

	    public void sapXepTangDan() {
	        if (soLuongPhanTu <= 1) return;
	        Arrays.sort(this.a);
	    }

	    public void sapXepGiamDan() {
	        if (soLuongPhanTu <= 1) return;

	        sapXepTangDan();
	        
	        for (int i = 0; i < soLuongPhanTu - 1; i++) {
	            for (int j = i + 1; j < soLuongPhanTu; j++) {
	                if (this.a[i] < this.a[j]) { 
	                    int temp = this.a[i];
	                    this.a[i] = this.a[j];
	                    this.a[j] = temp;
	                }
	            }
	        }
	    }
	}