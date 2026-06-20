//Trương Anh Tuấn - 220616
package module2.buoi2;
import java.util.Scanner;

public class GiaiPTBac2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập hệ số a: ");
        double a = sc.nextDouble();
        
        System.out.print("Nhập hệ số b: ");
        double b = sc.nextDouble();
        
        System.out.print("Nhập hệ số c: ");
        double c = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình có vô số nghiệm.");
                } else {
                    System.out.println("Phương trình vô nghiệm.");
                }
            } else {
                System.out.println("Phương trình có nghiệm duy nhất: x = " + (-c / b));
            }
        } else {

            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                System.out.println("Phương trình có hai nghiệm phân biệt:");
                System.out.println("x1 = " + (-b + Math.sqrt(delta)) / (2 * a));
                System.out.println("x2 = " + (-b - Math.sqrt(delta)) / (2 * a));
            } else if (delta == 0) {
                System.out.println("Phương trình có nghiệm kép: x = " + (-b / (2 * a)));
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        }
     }
}