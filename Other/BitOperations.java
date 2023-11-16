package Other;
import java.util.Scanner;


public class BitOperations {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("a\t"+Integer.toBinaryString(a));
        System.out.println("b\t"+Integer.toBinaryString(b));

        System.out.println("a|b\t"+Integer.toBinaryString(a|b));
        System.out.println("a&b\t"+Integer.toBinaryString(a&b));
        System.out.println("a^b\t"+Integer.toBinaryString(a^b));
        System.out.println("a>>3\t"+Integer.toBinaryString(a>>3));
        System.out.println("b<<3\t"+Integer.toBinaryString(3<<b));

    }
}
