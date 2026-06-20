//Trương Anh Tuấn 220616
package module3.buoi2.quanlythongtinsinhvien;
import java.util.Scanner;

public class SinhVien {
	private int maSV;
    private String hoTen;
    private float diemLT; 
    private float diemTH; 
    
    public SinhVien() {
        this.maSV = 0;
        this.hoTen = "";
        this.diemLT = 0.0f;
        this.diemTH = 0.0f;
    }
    
    public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }
    
    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên: ");
        this.maSV = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập họ tên: ");
        this.hoTen = sc.nextLine();

        System.out.print("Nhập điểm lý thuyết: ");
        this.diemLT = Float.parseFloat(sc.nextLine());

        System.out.print("Nhập điểm thực hành: ");
        this.diemTH = Float.parseFloat(sc.nextLine());
    }
    
    public void In() {
        System.out.printf(
            "%-15d %-25s %15.2f %15.2f %18.2f%n",
            maSV, hoTen, diemLT, diemTH, tinhDiemTB()
        );
    }

    
    public int getMaSV() { 
    	return maSV; 
    }
    public String getHoTen() { 
    	return hoTen; 
    }
    public float getDiemLT() { 
    	return diemLT; 
    }
    public float getDiemTH() { 
    	return diemTH; 
    }

    public void setMaSV(int maSV) {
    	this.maSV = maSV; 
    }
    public void setHoTen(String hoTen) { 
    	this.hoTen = hoTen; 
    }
    public void setDiemLT(float diemLT) { 
    	this.diemLT = diemLT; 
    }
    public void setDiemTH(float diemTH) { 
    	this.diemTH = diemTH; 
    }
   
    public float tinhDiemTB() {
        return (diemLT + diemTH) / 2.0f;
    }

    public String toString() {
        return maSV + " - " + hoTen + " diem Tb: " + tinhDiemTB();
    }
}
