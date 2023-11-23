package HW231116;

import java.util.Arrays;
import java.util.Random;

public class ScoreSorter {
    public static void main(String[] args) {
        Random rnd = new Random();
        Score scores[] = new Score[10];
        for(int i=0; i<scores.length; i++) {
            scores[i] = new Score(rnd.nextInt(101), rnd.nextInt(101), rnd.nextInt(101));
        }
        Arrays.sort(scores);

        for(int i=0; i<scores.length; i++) {
            System.out.printf("Total: %d\tChinese: %d\tEnglish: %d\tMath: %d\n"
                    , scores[i].getTotal()
                    , scores[i].getChinese()
                    , scores[i].getEnglish()
                    , scores[i].getMath()
            );
        }
    }
}
