package HW231012;
import java.util.Scanner;
import java.lang.Math;

public class QuadraticEquation {
    public static void main(String args[]) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        
        printRoot(a,b,c);
        sc.close();
    }

    static void printRoot(double a, double b, double c) {
        double flag = b*b-4*a*c;

        if(flag > 0) {
            System.out.printf("The two roots of equation");
            printEquation(a, b, c);
            System.out.printf("%.4f | %.4f\n",
                (-b + Math.sqrt(flag)) / 2*a,
                (-b - Math.sqrt(flag)) / 2*a
            );

        }
        if(flag == 0) {
            System.out.printf("The multiple real root of equation");
            printEquation(a, b, c);
            System.out.printf("%.4f", -b/(2*a));
        }
        if(flag < 0) {
            System.out.printf("The complex roots of equation");
            printEquation(a, b, c);
            System.out.printf("%.4f+%.4fi | %.4f-%.4fi\n", 
                -b/(2*a), Math.sqrt(-flag),
                -b/(2*a), Math.sqrt(-flag)
            );
        }

    }
    static void printEquation(double a, double b, double c) {
        System.out.printf(" %s%s%s%s%s%s%s = 0 is:\n",
            (a==-1) ? "- ": ((a==1 || a==0) ? "" : String.format("%.4f", a)),
            (a==0)  ? "" : " X^2 ",
            (b==0)  ? "" : ((b>0) ? "+" : "-"),
            (Math.abs(b)==1 || b==0) ? "" : String.format("%.4f", Math.abs(b)),
            (b==0)  ? "" : " X ",
            (c==0)  ? "" : ((c>0) ? "+" : "-"),
            (c==0)  ? "" : String.format("%.4f", Math.abs(c))
        );
    }
}
