package modulo2.buoi2;
import java.util.Scanner;

public class GiaiPTBac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập c: ");
        double c = sc.nextDouble();
        
        if (a == 0) {
        	if(b == 0 && c == 0) {	
    			System.out.println("Phuong trinh vo so nghiem");
    		} else if(b == 0 && c !=0 ) {
    			System.out.println("Phuong trinh vo nghiem");
    		} else {
    			double x = -c/b;
    			System.out.println("Phuong trinh co nghiem duy nhat x = "+x);
    		}
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm (delta < 0).");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Phương trình có nghiệm kép: x1 = x2 = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phương trình có 2 nghiệm phân biệt:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        }
        
        sc.close();
    }
}