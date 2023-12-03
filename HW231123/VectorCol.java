package HW231123;

public class VectorCol extends Matrix {
    VectorCol() {
        super();
    }

    VectorCol(int size) {
        super(size, 1);
    }

    public int getLength() {
        return getN();
    }

    public static VectorCol setFromMatrix(Matrix mat, int col) throws MatrixException {
        if(col >= mat.getM()) {
            throw new MatrixException(String.format("Column %d not exist", col));
        }
        
        VectorCol vc = new VectorCol(mat.getN());
        for(int i=0; i<mat.getN(); i++) {
            vc.setElement(i, 0, mat.getElement(i, col));
        }

        return vc;
    }

    public double dotMultiply(VectorRow mat) throws MatrixException {
        if(this.getLength() != mat.getLength()) {
            throw new MatrixException("Inner product vector length mismatch.");
        }
        return super.multiplication(mat).getElement(0, 0);
    }
    public double dotMultiply(VectorCol mat) throws MatrixException {
        if(this.getLength() != mat.getLength()) {
            throw new MatrixException("Inner product vector length mismatch.");
        }
        return super.multiplication(mat.transposition()).getElement(0, 0);
    }
}
