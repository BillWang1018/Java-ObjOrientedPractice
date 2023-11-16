package HW231019;

public class MatrixAPP {
    public static void main(String args[]) {
        Matrix mats[] = new Matrix[5];
        mats[0] = new Matrix(5, 4);
        mats[1] = new Matrix(5, 4);
        mats[2] = new Matrix(5, 4);
        mats[3] = new Matrix(4, 6);
        mats[4] = new Matrix(5, 6);
        
        for(int i=0; i<5; i++) {
            System.out.printf("Matrix %c:\n", 'A'+i);
            mats[i].printMatrix();
            System.out.printf("\n-------------------------------------------\n");
        }
        
        System.out.printf("Resulting Matrix of A+B-C:\n");
        mats[0].add(mats[1]).minus(mats[2]).printMatrix();
        System.out.printf("\n-------------------------------------------\n");
        
        System.out.printf("Resulting Matrix of B*D+E:\n");
        mats[1].times(mats[3]).add(mats[4]).printMatrix();
        System.out.printf("\n-------------------------------------------\n");

        System.out.printf("Resulting Matrix of E-A*D:\n");
        mats[4].minus(mats[0].times(mats[3])).printMatrix();
    }
}
