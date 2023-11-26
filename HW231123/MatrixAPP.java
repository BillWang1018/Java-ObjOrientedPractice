package HW231123;

public class MatrixAPP {
    public static void main(String[] args) {
        Matrix a = new Matrix(3, 3);
        a.randomMatrix();
        Matrix b = new Matrix(3, 3);
        b.randomMatrix();
        Matrix c = new Matrix(2, 1);
        c.randomMatrix();
        Matrix d = new Matrix(1, 2);
        d.randomMatrix();

        Matrix sum = a.addition(b);
        Matrix dif = a.subtraction(b);
        Matrix prd = c.multiplication(d);
        
        System.out.println("Matrix A:\n");
        a.printMatrix();
        System.out.println("Matrix B:\n");
        b.printMatrix();
        System.out.println("Matrix C:\n");
        c.printMatrix();
        System.out.println("Matrix D:\n");
        d.printMatrix();
        
        System.out.println("Sum AB:\n");
        sum.printMatrix();
        System.out.println("Difference AB:\n");
        dif.printMatrix();
        System.out.println("Product CD:\n");
        prd.printMatrix();
    }
}
