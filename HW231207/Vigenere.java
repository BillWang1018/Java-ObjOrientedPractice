package HW231207;

import java.util.Scanner;

public class Vigenere {
    
    private static final String keyword = "FENGCHIA";

    static String toUpper(String str) {
        return str.toUpperCase();
    }
    static String encode(String str) {
        int ki=0;
        str = toUpper(str);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if(!Character.isAlphabetic(str.charAt(i))) {
                sb.append(' ');
            } else {
                sb.append((char)((str.charAt(i)+keyword.charAt(ki)-'A'*2)%26 + 'A'));
                ki++;
            }

            if(ki >= keyword.length()) ki=0;
        }

        return sb.toString();
    }
    static String decode(String str) {
        int ki=0;
        str = toUpper(str);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if(!Character.isAlphabetic(str.charAt(i))) {
                sb.append(' ');
            } else {
                int c = (char)((str.charAt(i)-keyword.charAt(ki))%26 + 'A');
                sb.append((char)(c));
                ki++;
            }

            if(ki >= keyword.length()) ki=0;
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Original Text:  " + input);
        input = toUpper(input);
        System.out.println("Uppercase Text: " + input);
        input = encode(input);
        System.out.println("Encoded Text:   " + input);
        input = decode(input);
        System.out.println("Decoded Text:   " + input);
        sc.close();
    }
}
