//Trương Anh Tuấn 220616
package module3.buoi1.quanlyhinhhoc;

import java.util.Scanner;

public class TestHinhTron {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("HÌNH TRÒN ");
        HinhTron ht = new HinhTron();
        ht.nhapHinhTron(sc);
        System.out.println("\n** THÔNG TIN HÌNH TRÒN");
        ht.xuatHinhTron();

        sc.close();
    }
}
