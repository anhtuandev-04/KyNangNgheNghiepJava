//Trương Anh Tuấn 220616
package module3.buoi2.quanlyhocsinh;
import java.util.Scanner;

public class TestLopHoc {
	public static void main(String[] args) {
        LopHoc lop = new LopHoc();

        lop.nhapTTLopHoc();
        lop.xuatTTLopHoc();

        System.out.println("\n**Học sinh có điểm TB cao nhất:");
        lop.DTBMax().xuat();

        lop.xuatGioiXuatSac();

        System.out.println("\n**Danh sách sau khi sắp xếp tăng dần:");
        lop.sapXepTang();
        lop.xuatTTLopHoc();

        System.out.println("\n**Danh sách sau khi sắp xếp giảm dần:");
        lop.sapXepGiam();
        lop.xuatTTLopHoc();
	}
}
