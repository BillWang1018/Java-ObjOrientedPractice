package HW231123;

public class SquareMatrix extends Matrix {
    SquareMatrix() {
        super();
    }
    SquareMatrix(int size) {
        super(size, size);
    }

    public int getSize() {
        return getM();
    }

    public SquareMatrix cofactor(int i, int j) {
        SquareMatrix sm = new SquareMatrix(getSize()-1);
        short skip = 0;
        for(int x=0; x<sm.getSize(); x++) {
            if(x == i) {
                skip++;
                continue;
            }
            for(int y=0; y<sm.getSize(); y++) {
                if(y == j) {
                    skip+=2;
                    continue;
                }

                sm.setElement(x, y, sm.getElement(x+skip%2, y+skip/2));
            }
        }

        return sm;
    }

    public double determinant() {
        if(getSize() == 1) return getElement(0, 0);

        SquareMatrix cof = cofactor(0, f);
        double ans;
        for(int i=0; i<getM(); i++) {
            ans += (i%2 ? 1 : -1) * getElement(0, i); * cof.determinant();
        }

        return ans;
    }
}
