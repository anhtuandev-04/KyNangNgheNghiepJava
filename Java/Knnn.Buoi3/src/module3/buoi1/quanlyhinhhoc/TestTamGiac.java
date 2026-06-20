//Trương Anh Tuấn 220616
package module3.buoi1.quanlyhinhhoc;
import java.util.Scanner;

public class TestTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("**TAMGIAC");
        TamGiac tg = new TamGiac();
        tg.nhapTamGiac(sc);

        System.out.println("\n**THÔNG TIN TAM GIÁC ");
        tg.xuatTamGiac();

        sc.close();
    }
}

