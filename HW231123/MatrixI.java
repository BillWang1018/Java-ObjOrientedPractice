package HW231123;

class MatrixException extends Exception {
    MatrixException() {};
    MatrixException(String str) {super(str);}
}

public interface MatrixI {
    Matrix addition(Matrix mat) throws MatrixException;
    Matrix subtraction(Matrix mat) throws MatrixException;
    Matrix multiplication(Matrix mat) throws MatrixException;
    Matrix transposition();
}
