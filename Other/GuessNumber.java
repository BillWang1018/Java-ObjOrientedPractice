package Other;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class GuessNumber {
    public static void main(String args[]) {
        System.out.printf("Guess a number! (1~1000)\n");
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int ans = rnd.nextInt(1, 1001);
        int guess, org=1, bun=1000, count=0;
        while(true) {
            guess = sc.nextInt();
            count++;
            if(guess > ans) {
                bun = Math.min(guess, bun);
                System.out.printf("v lower v | (%d~%d)\n", org, bun);
            } else if (guess < ans) {
                org = Math.max(guess, org);
                System.out.printf("^ higher ^ | (%d~%d)\n", org, bun);
            } else { //correct guess
                System.out.printf("YOU GUESSED THE RIGHT ANSWER! HORRAY ;)\n");
                if(count == 1)
                    System.out.printf("!!!NO WAY YOU HIT IT FIRST GUESS!!!");
                else
                    System.out.printf("You used %d guesses.", count);
                break;
            }
            System.out.println("====================");
        }

        sc.close();
    }
}
