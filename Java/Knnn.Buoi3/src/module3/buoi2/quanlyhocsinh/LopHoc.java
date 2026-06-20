//Trương Anh Tuấn 220616
package module3.buoi2.quanlyhocsinh;
import java.util.Scanner;

public class LopHoc {
	private String maLop;
    private String tenLop;
    private int siSo;
    private HocSinh[] hs;

    public void nhapTTLopHoc() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("*NHẬP THÔNG TIN LỚP HỌC*");
        System.out.print("Nhập mã lớp: ");
        maLop = sc.nextLine();

        System.out.print("Nhập tên lớp: ");
        tenLop = sc.nextLine();

        System.out.print("Nhập sĩ số lớp: ");
        siSo = Integer.parseInt(sc.nextLine());

        hs = new HocSinh[siSo];

        System.out.println("\n*NHẬP DANH SÁCH HỌC SINH*");
        for (int i = 0; i < siSo; i++) {
            System.out.println("~Nhập thông tin học sinh thứ " + (i + 1) + ": ");
            hs[i] = new HocSinh();
            hs[i].nhap();
        }
    }

    public void xuatTTLopHoc() {
        System.out.println("\n*THÔNG TIN LỚP HỌC*");
        System.out.println("Mã lớp: " + maLop);
        System.out.println("Tên lớp: " + tenLop);
        System.out.println("Sĩ số: " + siSo);

        System.out.println("**DANH SÁCH HỌC SINH**");
        System.out.printf("%-10s %-20s %10s %10s %10s %-15s\n",
                "Mã", "Họ tên", "HK1", "HK2", "ĐTB", "Xếp loại");

        for (HocSinh h : hs) {
            h.xuat();
        }
    }

    public HocSinh DTBMax() {
        HocSinh max = hs[0];
        for (int i = 1; i < siSo; i++) {
            if (hs[i].getDTB() > max.getDTB()) {
                max = hs[i];
            }
        }
        return max;
    }

    public HocSinh DTBMin() {
        HocSinh min = hs[0];
        for (int i = 1; i < siSo; i++) {
            if (hs[i].getDTB() < min.getDTB()) {
                min = hs[i];
            }
        }
        return min;
    }

    public void xuatGioiXuatSac() {
        System.out.println("\n*HỌC SINH GIỎI VÀ HỌC SINH XUẤT SẮC*");
        for (HocSinh h : hs) {
            String xl = h.xepLoai();
            if (xl.equals("Giỏi") || xl.equals("Xuất sắc")) {
                h.xuat();
            }
        }
    }

    public void sapXepGiam() {
        for (int i = 0; i < siSo - 1; i++) {
            for (int j = i + 1; j < siSo; j++) {
                if (hs[i].getDTB() < hs[j].getDTB()) {
                    HocSinh temp = hs[i];
                    hs[i] = hs[j];
                    hs[j] = temp;
                }
            }
        }
    }

    public void sapXepTang() {
        for (int i = 0; i < siSo - 1; i++) {
            for (int j = i + 1; j < siSo; j++) {
                if (hs[i].getDTB() > hs[j].getDTB()) {
                    HocSinh temp = hs[i];
                    hs[i] = hs[j];
                    hs[j] = temp;
                }
            }
        }
    }
}