package HW231019;

import java.util.Scanner;

public class ComplexNumber_main1 {
    public static void main(String[] args) {
        double a,b,c,d;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first complex number a + bi = ");
        a = sc.nextDouble(); b = sc.nextDouble();
        System.out.print("Enter the second complex number c + di = ");
        c = sc.nextDouble(); d = sc.nextDouble();

        ComplexNumber c1 = new ComplexNumber(a, b);
        ComplexNumber c2 = new ComplexNumber(c, d);

        System.out.printf("The complex numbers are %.4f %s%.4f%s and %.4f %s%.4f%s\n\n",
            a, (b>0 ? "+":""), b, (b!=0 ? "i":""), c, (d>0 ? "+":""), d, (d!=0 ? "i":"")
        );

        System.out.println("After complex number arithmetic operations:");
        System.out.println("===================================");

        System.out.print("Complex addition: ");
        c1.plus(c2).printComplex(2);
        System.out.println();
        System.out.print("Complex subtraction: ");
        c1.minus(c2).printComplex(2);
        System.out.println();
        System.out.print("Complex multiplication: ");
        c1.times(c2).printComplex(4);
        System.out.println();
        System.out.print("Complex division: ");
        c1.div(c2).printComplex(4);
        System.out.println();
        System.out.print("Complex absolute: ");
        System.out.println(c1.abs(c2));
        



    }
}
