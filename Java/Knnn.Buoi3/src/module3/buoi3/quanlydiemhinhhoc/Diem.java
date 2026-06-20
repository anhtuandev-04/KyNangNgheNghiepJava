//Trương Anh Tuấn 220616
package module3.buoi3.quanlydiemhinhhoc;
import java.util.Scanner;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Diem {
    private int x;
    private int y;

    public Diem() {
        this.x = 0;
        this.y = 0;
    }

    public Diem(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public void nhapToaDo(Scanner scanner) {
        System.out.print(" Nhập x: ");
        this.x = scanner.nextInt();
        System.out.print(" Nhập y: ");
        this.y = scanner.nextInt();
    }

    public void xuatToaDo() {
        System.out.print("(" + this.x + "," + this.y + ")");
    }

    public double tinhKhoangCach(Diem d1) {
        double deltaX = d1.x - this.x;
        double deltaY = d1.y - this.y;
        
        return sqrt(pow(deltaX, 2) + pow(deltaY, 2));
    }
}
