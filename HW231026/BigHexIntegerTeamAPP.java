package HW231026;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class BigHexIntegerTeamAPP {
    private static BigInteger nums[] = new BigInteger[6];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
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
                
        String str = sc.next();
        ans = eval(str);
        System.out.printf("%s\t%s(BigInteger)\t| %s(BigHexInteger)\n",
                str, ans, ans.toString(16).toUpperCase());

        sc.close();
    }

    static int order(char op) {
        if(op == '+' || op == '-') 
            return 1;
        if(op == '*' || op == '/')
            return 2;
        return 0;
    }

    static BigInteger eval(String str) {
        String post = new String();
        Stack<Character> s = new Stack<Character>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '=') break;

            if(Character.isAlphabetic(str.charAt(i))) {
                post += str.charAt(i);
            } else {
                while(!s.isEmpty() && order(s.peek()) >= order(str.charAt(i))) {
                    post += s.pop();
                }
                s.push(str.charAt(i));
            }
        }
        while(!s.isEmpty()) {
            post += s.pop();
        }

        System.out.println("Postfix -> " + post);

        Stack<BigInteger> snum = new Stack<BigInteger>();
        for(int i=0; i<post.length(); i++) {
            if(Character.isAlphabetic(post.charAt(i))) {
                snum.push(nums[post.charAt(i)-'a']);
            } else if(post.charAt(i) == '+') {
                snum.push(snum.pop().add(snum.pop()));
            } else if(post.charAt(i) == '-') {
                BigInteger tmp = snum.pop();
                snum.push(snum.pop().subtract(tmp));
            } else {
                continue;
            }
        }
        return snum.pop();
    }
}
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