package HW231123;

public class SquareMatrix extends Matrix {
    SquareMatrix() {
        super();
    }
    SquareMatrix(int size) {
        super(size, size);
    }
    SquareMatrix(Matrix mat) throws MatrixException {
        super(mat.getM(), mat.getM());
        if(mat.getN() != mat.getM()) {
            throw new MatrixException("Not a square matrix.");
        }
        for(int i=0; i<getSize(); i++) {
            for(int j=0; j<getSize(); j++) {
                setElement(i, j, mat.getElement(i, j));
            }
        }
    }

    public int getSize() {
        return getM();
    }

    public SquareMatrix cofactor(int i, int j) {
        // System.out.printf("i=%d | j=%d\n", i, j);
        SquareMatrix sm = new SquareMatrix(getSize()-1);
        short skip = 0;
        for(int x=0; x<sm.getSize(); x++) {
            if(x == i) skip++;

            for(int y=0; y<sm.getSize(); y++) {
                if(y == j) skip+=2;
                // System.out.printf("%d | %d | skip=%d\n", x+skip%2, y+skip/2, skip);;
                sm.setElement(x, y, getElement(x+skip%2, y+skip/2));
            }
            if(skip >= 2) skip-=2;
        }
        // System.out.println("=========");
        return sm;
    }

    public double determinant() {
        if(getSize() == 1) return getElement(0, 0);

        SquareMatrix cof;
        double ans = 0;
        for(int i=0; i<getSize(); i++) {
            cof = cofactor(0, i);
            ans += (i%2==0 ? 1 : -1) * getElement(0, i) * cof.determinant();
        }

        return ans;
    }
}
