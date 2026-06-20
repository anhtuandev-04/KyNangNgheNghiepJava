//Trương Anh Tuấn 220616
package module3.buoi3.loptamgiac;
import java.util.Scanner;

public class TamGiac {
	private double a;
    private double b;
    private double c;

    public TamGiac() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public TamGiac(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void nhapTamGiac(Scanner sc) {
        System.out.print("Nhập cạnh a: ");
        a = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập cạnh b: ");
        b = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập cạnh c: ");
        c = Double.parseDouble(sc.nextLine());
    }

    public void xuatTamGiac() {
        System.out.println("Cạnh a = " + a + ", b = " + b + ", c = " + c);
    }

    public boolean hopLe() {
        return a + b > c && a + c > b && b + c > a;
    }

    public String phanLoai() {
        if (!hopLe()) return "Không phải tam giác";
        if (a == b && b == c) return "Tam giác đều";
        if (a == b || b == c || a == c) return "Tam giác cân";
        if ((a*a + b*b) == (c*c) || (a*a + c*c) == (b*b) || (b*b + c*c) == (a*a)) {
        	    return "Tam giác vuông";
        	}
        return "Tam giác thường";
    }

    public double chuVi() {
        if (!hopLe()) return 0;
        return a + b + c;
    }

    public double dienTich() {
        if (!hopLe()) return 0;
        double p = chuVi()/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}