package HW231214;

import java.util.Scanner;

public class Palindrome {
    static boolean isPalindrome(String str) {
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) 
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            System.out.print(">>>> Enter a String: ");
            str = sc.nextLine().trim();
            if (str.equals("000")) break;
            System.out.printf("%s\n", isPalindrome(str) ?
                    "**** Yes, it is a palindrome."            :
                    "**** No, it is not a palindrome."
            );
        }
        sc.close();
    }
}
