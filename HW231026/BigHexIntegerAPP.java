package HW231026;

import java.math.BigInteger;
import java.util.Scanner;

public class BigHexIntegerAPP {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BigInteger nums[] = new BigInteger[6];
        
        for(int i=0; i<6; i++) {
            System.out.printf("%c(%s):\t", 'a'+i, (i%2==0) ? "dec" : "hex");
            if(i%2 == 0) {
                nums[i] = new BigInteger(sc.next());
            } else {
                nums[i] = new BigInteger(sc.next(), 16);
            }
        }

        BigInteger ans = BigInteger.ZERO;
        for(int i=0; i<6; i++) {
            ans = ans.add(nums[i]);
        }
        
        System.out.printf("a+b+c+d+e+f=\t%s(BigInteger)\t| %s(BigHexInteger)\n",
                ans, ans.toString(16).toUpperCase());
                
        ans = BigInteger.ZERO;
        ans = ans.add(nums[1]).subtract(nums[2]).add(nums[3]).add(nums[4]).subtract(nums[5]).add(nums[0]);

        System.out.printf("b-c+d+e-f+a=\t%s(BigInteger)\t| %s(BigHexInteger)\n",
                ans, ans.toString(16).toUpperCase());

        sc.close();
    }
}
// -a-a+a+(-a)-(-a)+a
/*
 * 
121
FF
-28
-1C
83
2B
 * 
 */