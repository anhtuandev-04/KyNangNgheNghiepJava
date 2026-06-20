//Trương Anh Tuấn 220616
package module3.buoi3.quanlythisinh;
import java.util.Scanner;

public class ThiSinh {
	private String soBaoDanh;
    private String hoTen;
    private String diaChi;
    private double diemToan;
    private double diemLy;
    private double diemHoa;

    public ThiSinh() {
        this.soBaoDanh = "";
        this.hoTen = "";
        this.diaChi = "";
        this.diemToan = 0.0;
        this.diemLy = 0.0;
        this.diemHoa = 0.0;
    }

    public String getSoBaoDanh() { return soBaoDanh; }
    public String getHoTen() { return hoTen; }
    public String getDiaChi() { return diaChi; }
    public double tinhDiemTong() {

        return diemToan + diemLy + diemHoa;
    }

    public void nhapThongTin(Scanner scanner) {
        System.out.print("Nhập SBD: ");
        this.soBaoDanh = scanner.nextLine();
        System.out.print("Nhập Họ tên: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhập Địa chỉ: ");
        this.diaChi = scanner.nextLine();
        System.out.print("Nhập Điểm Toán: ");
        if (scanner.hasNextDouble()) {
            this.diemToan = scanner.nextDouble();
        } else {
            this.diemToan = 0.0;
            scanner.next(); 
        }
        
        System.out.print("Nhập Điểm Lý: ");
        if (scanner.hasNextDouble()) {
            this.diemLy = scanner.nextDouble();
        } else {
            this.diemLy = 0.0;
            scanner.next();
        }

        System.out.print("Nhập Điểm Hóa: ");
        if (scanner.hasNextDouble()) {
            this.diemHoa = scanner.nextDouble();
        } else {
            this.diemHoa = 0.0;
            scanner.next();
        }
        scanner.nextLine();
    }

    public void xuatThongTin() {
        System.out.printf("| %-12s | %-20s | %-25s | %-8.2f | %-8.2f | %-8.2f | %-8.2f |%n",
        this.soBaoDanh, 
        this.hoTen,
        this.diaChi,
        this.diemToan, 
        this.diemLy, 
        this.diemHoa, 
        tinhDiemTong());
    }
}