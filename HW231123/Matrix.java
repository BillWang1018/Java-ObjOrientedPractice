package HW231123;

import java.util.Random;

public class Matrix implements MatrixI {

    private int n, m; // size of N*M

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    private double matrix[][];
    public void setElement(int r, int c, double num) {
        matrix[r][c] = num;
    }
    public double getElement(int r, int c) {
        return matrix[r][c];
    }
    
    Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new double[n][m]; 
    }

    Matrix() {
        this.n = this.m = 0;
        matrix = new double[0][0];
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
    public Matrix addition(Matrix mat) throws MatrixException {
        
        if(this.m != mat.m || this.n != mat.n) {
            throw new MatrixException(String.format(
                    "Addition: mismatch matrix size (%dx%d & %dx%d)",
                    this.n, this.m, mat.n, mat.m)
            );
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
    public Matrix subtraction(Matrix mat) throws MatrixException {
        if(this.m != mat.m || this.n != mat.n) {
            throw new MatrixException(String.format(
                    "Subtraction: mismatch matrix size (%dx%d & %dx%d)",
                    this.n, this.m, mat.n, mat.m)
            );
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
    public Matrix multiplication(Matrix mat) throws MatrixException {
        
        if(this.m != mat.n) {
            throw new MatrixException(String.format(
                    "Multiplication: mismatch matrix size (%dx%d & %dx%d)",
                    this.n, this.m, mat.n, mat.m)
            );
        }

        Matrix prd = new Matrix(this.n, mat.m);

        for(int i=0; i<this.n; i++) {
            for(int j=0; j<mat.m; j++) {
                for(int a=0; a<this.m; a++) {
                    prd.matrix[i][j] += this.matrix[i][a] * mat.matrix[a][j];
                }
            }
        }

        return prd;
    }

    @Override
    public Matrix transposition() {
        Matrix trans = new Matrix(m, n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                trans.matrix[j][i] = this.matrix[i][j];
            }
        }
        
        return trans;
    }
}
