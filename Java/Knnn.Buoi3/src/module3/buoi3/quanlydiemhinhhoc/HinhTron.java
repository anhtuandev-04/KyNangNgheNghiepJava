//Trương Anh Tuấn 220616
package module3.buoi3.quanlydiemhinhhoc;
import java.util.Scanner;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class HinhTron {
    private int R; 
    
    public HinhTron() {
        this.R = 0;
    }

    public HinhTron(int R) {
        this.R = R;
    }

    public void nhapHinhTron(Scanner scanner) {
        System.out.print("Nhập bán kính R: ");
        if (scanner.hasNextInt()) {
            this.R = scanner.nextInt();
        } else {
            this.R = 0;
            scanner.next();
        }
        scanner.nextLine();
    }

    public void xuatHinhTron() {
        System.out.printf("Hình tròn có bán kính R = %d%n", this.R);
    }

    public double tinhChuVi() {
        return 2 * PI * this.R;
    }

    public double tinhDienTich() {
        return PI * pow(this.R, 2);
    }
}
