package HW231123;

public class VectorRow extends Matrix {
    VectorRow() {
        super();
    }

    VectorRow(int size) {
        super(1, size);
    }

    public int getLength() {
        return getM();
    }

    public static VectorRow setFromMatrix(Matrix mat, int row) throws MatrixException {
        if(row >= mat.getN()) {
            throw new MatrixException(String.format("Row %d not exist", row));
        }
        
        VectorRow vr = new VectorRow(mat.getM());
        for(int i=0; i<mat.getM(); i++) {
            vr.setElement(0, i, mat.getElement(row, i));
        }

        return vr;
    }


    public double dotMultiply(VectorRow mat) throws MatrixException {
        if(this.getLength() != mat.getLength()) {
            throw new MatrixException("Inner product vector length mismatch.");
        }
        return super.multiplication(mat.transposition()).getElement(0, 0);
    }
    public double dotMultiply(VectorCol mat) throws MatrixException {
        if(this.getLength() != mat.getLength()) {
            throw new MatrixException("Inner product vector length mismatch.");
        }
        return super.multiplication(mat).getElement(0, 0);
    }
}
