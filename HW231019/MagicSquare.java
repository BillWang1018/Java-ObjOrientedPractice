package HW231019;

import java.util.Scanner;

public class MagicSquare {
    public static void main(String []args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the size of the magic square (3<=n<18, odd integer): ");
        n = sc.nextInt();
        int [][]nums = new int[n][n];

        int x=0, y=n/2, k=0;
        nums[x][y] = ++k;
        while(k < n*n) {
            x--; y--;
            x += (x<0 ? n:0);
            y += (y<0 ? n:0);
            if(nums[x][y] == 0) {
                nums[x][y] = ++k;
                continue;
            }
            x+=2; y++;
            x -= (x>=n ? n:0);
            y -= (y>=n ? n:0);
            if(nums[x][y] == 0) {
                nums[x][y] = ++k;
                continue;
            }
            break;
        }

        System.out.printf("The magic square of degree %d:\n", n);
        for(x=0; x<n; x++) {
            for(y=0; y<n; y++) {
                System.out.printf("%d\t", nums[x][y]);
            }
            System.out.println();
        }

        /// verification ///
        boolean flag = true;
        int csum, rsum, dsum, adsum;
        csum = rsum = dsum = adsum = 0;
        for(int i=0; i<n; i++) {
            csum = rsum = 0;
            for(int j=0; j<n; j++) {
                csum += nums[i][j];
                rsum += nums[j][i];
            }
            if(!(flag && csum == rsum))  {
                flag = false;
                break;
            }
            dsum += nums[i][i];
            adsum += nums[i][n-1-i];
        }
        if(flag && dsum == adsum) {
            System.out.printf("The magic square passes verification.\n");
            System.out.printf("The sum of each row, each column, diagonal, and anti-diagonal is %d.\n", csum);
        } else {
            System.out.printf("The magic square failed verification... (%d, %d, %d, %d)\n", csum, rsum, dsum, adsum);
        }

    } 
}
