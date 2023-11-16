package HW231019;

import java.util.Random;

public class Matrix {
    private int col, row;
    private int[][] nums;

    public Matrix() {
        this.col = 0;
        this.row = 0;
    }
    
    public Matrix(int col, int row) {
        this.col = col;
        this.row = row;
        Random rnd = new Random();
        nums = new int[col][row];
        for(int x=0; x<col; x++) {
            for(int y=0; y<row; y++) {
                nums[x][y] = rnd.nextInt(-60,61);
            }
        }
    }
    
    public Matrix add(Matrix m) {
        if(this.col != m.col || this.row != m.row) {
            System.out.printf("These matrices aren't capable for adding!\n");
            return this;
        }

        Matrix ans = new Matrix(col, row);
        for(int x=0; x<col; x++) {
            for(int y=0; y<row; y++) {
                ans.nums[x][y] = nums[x][y] + m.nums[x][y];
            }
        }
        return ans;
    }

    public Matrix minus(Matrix m) {
        if(this.col != m.col || this.row != m.row) {
            System.out.printf("These matrices aren't capable for subtracting!\n");
            return this;
        }

        Matrix ans = new Matrix(col, row);
        for(int x=0; x<col; x++) {
            for(int y=0; y<row; y++) {
                ans.nums[x][y] = nums[x][y] - m.nums[x][y];
            }
        }
        return ans;
    }

    public Matrix times(Matrix m) {
        if(this.row != m.col) {
            System.out.printf("These matrices aren't capable for mutiplying\n");
            return this;
        }

        Matrix ans = new Matrix(this.col, m.row);
        for(int x=0; x<col; x++) {
            for(int y=0; y<row; y++) {
                ans.nums[x][y] = 0;
                for(int i=0; i<this.row; i++) {
                    ans.nums[x][y] += nums[x][i] * m.nums[i][y];
                }
            }
        }
        return ans;
    }

    public void printMatrix() {
        for(int x=0; x<col; x++) {
            for(int y=0; y<row; y++) {
                System.out.printf("\t%d", nums[x][y]);
            }
            System.out.println();
        }
    }
}
