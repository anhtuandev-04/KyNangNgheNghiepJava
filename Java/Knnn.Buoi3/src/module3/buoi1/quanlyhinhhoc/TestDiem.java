//Trương Anh Tuấn 220616
package module3.buoi1.quanlyhinhhoc;

import java.util.Scanner;
public class TestDiem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*LỚP ĐIỂM*");
        Diem A = new Diem();
        System.out.println("Nhập điểm A:");
        A.nhapDiem(sc);

        Diem B = new Diem();
        System.out.println("\nNhập điểm B:");
        B.nhapDiem(sc);

        System.out.print("Tọa độ điểm A là: ");
        A.xuatDiem();
        System.out.print("Tọa độ điểm B là: ");
        B.xuatDiem();

        System.out.println("\nKhoảng cách A-B = " + A.khoangCach(B));

        sc.close();
    }
}
