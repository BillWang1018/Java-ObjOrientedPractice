package HW231123;

public class MatrixAPP {
    public static void main(String[] args) {
        Matrix a = new Matrix(6, 4);
        a.randomMatrix();
        Matrix b = new Matrix(6, 4);
        b.randomMatrix();
        Matrix c = new Matrix(4, 6);
        c.randomMatrix();
        // Matrix d = new Matrix(1, 2);
        // d.randomMatrix();
        System.out.println("Matrix A:");
        a.printMatrix();
        System.out.println("======================");
        System.out.println("Matrix B:");
        b.printMatrix();
        System.out.println("======================");
        System.out.println("Matrix C:");
        c.printMatrix();
        System.out.println("======================");

        
        Matrix sol;
        
        try {
            System.out.println("Matrix A+B:");
            sol = a.addition(b);
            sol.printMatrix();
            System.out.println("======================");

            System.out.println("Matrix A-B:");
            sol = a.subtraction(b);
            sol.printMatrix();
            System.out.println("======================");

            System.out.println("Matrix A*C:");
            sol = a.multiplication(c);
            sol.printMatrix();
            System.out.println("======================");
            
            System.out.println("Matrix C*A:");
            sol = c.multiplication(a);
            sol.printMatrix();
            System.out.println("======================");
            
            System.out.println("Matrix (B-A)T:");
            sol = b.subtraction(a).transposition();
            sol.printMatrix();
            System.out.println("======================");
            
            System.out.println("Matrix C-A:");
            sol = c.subtraction(a);
            sol.printMatrix();
            System.out.println("======================");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.err.println("======================");
        }
        
        
        VectorRow vecr = new VectorRow();
        try {
            for(int i=0; i<=6; i++) {
                System.out.printf("Row %d of matrix A:\n", i);
                vecr = VectorRow.setFromMatrix(a, i);
                vecr.printMatrix();
                System.out.println("======================");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.err.println("======================");
        }
        
        
        VectorCol vecc;
        try {
            System.out.printf("Column %d of matrix A:\n", 0);
            vecc = VectorCol.setFromMatrix(a, 0);
            vecc.printMatrix();
            System.out.println("======================");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.err.println("======================");
        }
        
        
        VectorRow vr1, vr2;
        VectorCol vc1, vc2;

        try {
            vc1 = VectorCol.setFromMatrix(a, 0);
            vc2 = VectorCol.setFromMatrix(b, 0);
            System.out.println("Column A[*][0]:");
            vc1.transposition().printMatrix();
            System.out.println("Column B[*][0]:");
            vc2.transposition().printMatrix();
            System.out.printf("Inner product of A[*][0] and B[*][0]: %.4f\n", vc1.dotMultiply(vc2));
            System.out.println("======================");
        } catch (MatrixException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.err.println("======================");
        }

        try {
            vc1 = VectorCol.setFromMatrix(a, 0);
            vr1 = VectorRow.setFromMatrix(c, 0);
            System.out.println("Column A[*][0]:");
            vc1.transposition().printMatrix();
            System.out.println("Row C[0][*]:");
            vr1.printMatrix();
            System.out.printf("A[*][0] * C[0][*]:\n");
            vr1.multiplication(vc1).printMatrix();
            System.out.println("======================");
        } catch (MatrixException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.err.println("======================");
        }

        try {
            vc1 = VectorCol.setFromMatrix(a, 1);
            vc2 = VectorCol.setFromMatrix(c, 1);
            System.out.println("Column A[*][1]:");
            vc1.transposition().printMatrix();
            System.out.println("Column C[*][1]:");
            vc2.transposition().printMatrix();
            System.out.printf("Inner product of A[*][1] and C[*][1]: %.4f\n", vc1.dotMultiply(vc2));
            System.out.println("======================");
        } catch (MatrixException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.err.println("======================");
        }

        SquareMatrix s = new SquareMatrix(6);
        s.randomMatrix();
        try {
            S.determinant().printMatrix();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.err.println("======================");
        }
    }
}
