package HW231019;

import java.util.Scanner;

public class ComplexNumber_main2 {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter coefficient a: ");
        a = sc.nextDouble();
        System.out.print("Enter coefficient b: ");
        b = sc.nextDouble();
        System.out.print("Enter coefficient c: ");
        c = sc.nextDouble();

        printRoot(a,b,c);
        
        sc.close();
    }

    static void printRoot(double a, double b, double c) {
        double flag = b*b-4*a*c;

        if(flag > 0) {
            System.out.printf("The two roots of quadratic equation ");
            printEquation(a, b, c);
            ComplexNumber c1 = new ComplexNumber((-b + Math.sqrt(flag))/(2*a));
            ComplexNumber c2 = new ComplexNumber((-b - Math.sqrt(flag))/(2*a));
            System.out.print("are: ");
            c1.printComplex(4);
            System.out.print(" and ");
            c2.printComplex(4);
            System.out.println();
            
        }
        if(flag == 0) {
            System.out.printf("The multiple real root of quadratic equation ");
            printEquation(a, b, c);
            System.out.print("is: ");
            ComplexNumber c1 = new ComplexNumber(-b / (2*a), 0);
            c1.printComplex(4);
            System.out.println();
        }
        if(flag < 0) {
            System.out.printf("The two complex roots of quadratic equation ");
            printEquation(a, b, c);
            ComplexNumber c1 = new ComplexNumber(-b / (2*a), Math.sqrt(-flag) / (2*a));
            ComplexNumber c2 = new ComplexNumber(-b / (2*a), -Math.sqrt(-flag) / (2*a));
            System.out.print("are: ");
            c1.printComplex(4);
            System.out.print(" and ");
            c2.printComplex(4);
            System.out.println();
        }

    }

    static void printEquation(double a, double b, double c) {
        System.out.printf(" %s%s%s%s%s%s%s = 0.0000\n",
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
