package HW231102;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int n, ra, rb, sa, sb;
        System.out.print("Enter integer n for square matrix size: ");
        n = sc.nextInt();
        System.out.print("Enter lower bandwidth and upper bandwidth of matrix A: ");
        ra = sc.nextInt();
        sa = sc.nextInt();
        System.out.print("Enter lower bandwidth and upper bandwidth of matrix B: ");
        rb = sc.nextInt();
        sb = sc.nextInt();
        
        if(ra > n || rb > n || sa > n || sb > n) {
            System.out.println("Bandwidth too small");
            sc.close();
            return;
        }

        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] c = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                a[i][j] = rnd.nextInt(-50, 51);
                b[i][j] = rnd.nextInt(-50, 51);
            }
        }
        
        int sum;
        for(int i=0; i<n; i++) {
            for(int j=Math.max(0, i-ra-rb); j<=Math.min(n-1, i+sa+sb); j++) {
                sum=0;
                for(int k=Math.max(0, Math.max(i-ra, j-sb)); k<=Math.min(n-1, Math.min(i+sa, i+rb)); k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
            }
        }
        
        System.out.println("Matrix A:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(Math.max(0, i-ra) <= j && j <= Math.min(n-1, i+sa)) {
                    System.out.printf("%d\t", a[i][j]);
                } else {
                    System.out.printf("\t");
                }
            }
            System.out.println();
        }
        System.err.println("Matrix B:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(Math.max(0, i-rb) <= j && j <= Math.min(n-1, i+sb)) {
                    System.out.printf("%d\t", b[i][j]);
                } else {
                    System.out.printf("\t");
                }
            }
            System.out.println();
        }
        System.err.println("Matrix C:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(Math.max(0, i-ra-rb) <= j && j <= Math.min(n-1, i+sa+sb)) {
                    System.out.printf("%d\t", c[i][j]);
                } else {
                    System.out.printf("\t");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}