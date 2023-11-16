package HW231012;

import java.util.Scanner;

public class RationalNumber_main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RationalNumber[] rnums = new RationalNumber[5]; 

        String str;
        for(int i=0; i<5; i++) {
            System.out.print((char)('a'+i) + " = ");
            str = sc.nextLine();
            if (str.contains("/")) {
                rnums[i] = new RationalNumber(
                    Integer.parseInt(str.substring(0, str.indexOf("/"))), 
                    Integer.parseInt(str.substring(str.indexOf("/")+1, str.length()))
                );
            } else {
                rnums[i] = new RationalNumber(
                    Integer.parseInt(str.substring(0, str.length()))
                );
            }
        }

        // QUESTIONS
        System.out.printf("\n----------------------------------------------\n\n");

        System.out.print("a+b = ");
        rnums[0].plus(rnums[1]).printRational();
        System.out.print("c-d = ");
        rnums[2].minus(rnums[3]).printRational();
        System.out.print("a*b = ");
        rnums[0].times(rnums[1]).printRational();
        System.out.print("c/d = ");
        rnums[2].div(rnums[3]).printRational();
        System.out.print("|e| = ");
        rnums[4].abs().printRational();
        System.out.print("( a * |d - b|) - (b + (c / a)) * |(b * e) - (c / d)| = ");
        rnums[0].times(rnums[3].minus(rnums[1]).abs())
            .minus(rnums[1].plus(rnums[2].div(rnums[0]))
            .times((rnums[1].times(rnums[4]).minus(rnums[2].div(rnums[3]))).abs())).printRational();

        sc.close();
    }
}
