package HW231123;

import java.util.Random;

class MatrixException extends Exception {
    MatrixException() {};
    MatrixException(String str) {super(str);}
}

public class Matrix implements MatrixI {

    int n, m;
    double matrix[][];
    
    Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new double[n][m]; 
    }

    public void randomMatrix() {
        Random rnd = new Random();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = rnd.nextDouble();
            }
        }
    }

    public void printMatrix() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.printf("%.4f\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public Matrix addition(Matrix mat) {
        try {
            if(this.m != mat.m || this.n != mat.n) {
                throw new MatrixException("Two matrices aren't capable for adding.\n");
            }
        } catch (Exception e) {
            return this;
        }

        Matrix sum = new Matrix(this.n, this.m);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sum.matrix[i][j] = this.matrix[i][j] + mat.matrix[i][j];
            }
        }
        return sum;
    }

    @Override
    public Matrix subtraction(Matrix mat) {
        try {
            if(this.m != mat.m || this.n != mat.n) {
                throw new MatrixException("Two matrices aren't capable for subtrating.\n");
            }
        } catch (Exception e) {
            return this;
        }

        Matrix dif = new Matrix(this.n, this.m);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dif.matrix[i][j] = this.matrix[i][j] - mat.matrix[i][j];
            }
        }
        return dif;
    }

    @Override
    public Matrix multiplication(Matrix mat) {
        try {
            if(this.m != mat.n) {
                throw new MatrixException("Two matrices aren't capable for multiplication.\n");
            }
        } catch (Exception e) {
            return this;
        }

        Matrix prd = new Matrix(this.n, mat.m);

        for(int i=0; i<this.n; i++) {
            for(int j=0; j<mat.m; j++) {
                for(int a=0; a<this.m; a++) {
                    System.out.printf("%d | %d\n", i, j);
                    prd.matrix[i][j] += this.matrix[i][a] * mat.matrix[a][j];
                }
            }
        }

        return prd;
    }

    @Override
    public void transposition() {
        Matrix trans = new Matrix(m, n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                trans.matrix[j][i] = this.matrix[i][j];
            }
        }
    }
    
}
