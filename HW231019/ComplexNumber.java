package HW231019;

public class ComplexNumber {
    private double real;
    private double imaginary;

    ComplexNumber() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }
    ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0.0;
    }
    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getRe() {
        return real;
    }

    public void setRe(double real) {
        this.real = real;
    }

    public double getIm() {
        return imaginary;
    }

    public void setIm(double imaginary) {
        this.imaginary = imaginary;
    }

    public void printComplex(int depth) {
        String fprec = new String("%."+depth+"f");
        if (real != 0 && imaginary != 0)
            System.out.printf(fprec+"%s"+fprec+"i", real, (imaginary>=0 ? "+" : ""), imaginary);
        else if (real != 0)
            System.out.printf(fprec, real);
        else if (real == 0)
            System.out.printf(fprec+"i", imaginary);
    }

    public ComplexNumber plus(ComplexNumber a) {
        return new ComplexNumber(this.real+a.real, this.imaginary+a.imaginary);
    }
    public ComplexNumber minus(ComplexNumber a) {
        return new ComplexNumber(this.real-a.real, this.imaginary-a.imaginary);
    }
    public ComplexNumber times(ComplexNumber a) {
        return new ComplexNumber(this.real*a.real-this.imaginary*a.imaginary, this.real*a.imaginary+this.imaginary*a.real);
    }
    public ComplexNumber div(ComplexNumber a) {
        ComplexNumber m = this.times(a);
        double q = a.real*a.real + a.imaginary*a.imaginary;
        return new ComplexNumber(m.real/q, m.imaginary/q);
    }
    public double abs(ComplexNumber a) {
        return Math.sqrt(real*real + imaginary*imaginary);
    }


}
