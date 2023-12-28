package HW231207;

import java.util.Scanner;

public class Vigenere {
    
    private static String keyword = "FENGCHIA"; // Object Oriented Programming
    private static final String table = "ICOXDPBUQJARHKNGWYLEZSVFMT";

    static String toUpper(String str) {
        return str.toUpperCase();
    }
    static String encode(String str) {
        str = str.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i=0, j=0; i<str.length(); i++, j++) {
            if (!Character.isLetter(str.charAt(i))) {
                sb.append(str.charAt(i));
                j--; continue;
            }
            if (j == keyword.length()) j=0;
            int offset = table.indexOf(keyword.charAt(j));
            int index = (str.charAt(i) - 'A' + offset) % 26;
            sb.append((char)(table.charAt(index)));
        }
        return sb.toString();
    }
    static String decode(String str) {
        str = str.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0, j=0; i<str.length(); i++, j++) {
            if (!Character.isLetter(str.charAt(i))) {
                sb.append(str.charAt(i));
                j--; continue;
            }
            if (j == keyword.length()) j=0;
            int offset = table.indexOf(keyword.charAt(j));
            int index = (table.indexOf(str.charAt(i)) - offset + 26) % 26;
            sb.append((char)(index + 'A'));
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Keyword: ");
        keyword = sc.nextLine().trim().toUpperCase();
        System.out.print("Original Text:  ");
        String input = sc.nextLine().trim();
        input = toUpper(input);
        System.out.println("Uppercase Text: " + input);
        input = encode(input);
        System.out.println("Encoded Text:   " + input);
        input = decode(input);
        System.out.println("Decoded Text:   " + input);
        sc.close();
    }
}
