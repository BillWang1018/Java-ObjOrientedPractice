package HW231012;

public class RationalNumber {
    private int numerator;
    private int denominator;

    RationalNumber(int p, int q) {
        int gcd = gcd(p, q);
        if ((p < 0 && q < 0) || (p > 0 && q < 0)) {
            p *= -1; q *= -1;
        }
        this.numerator = p/gcd;
        this.denominator = q/gcd;
    }

    RationalNumber(int p) {
        this.numerator = p;
        this.denominator = 1;
    }

    RationalNumber() {
        this.numerator = 0;
        this.denominator = 1;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a); b = Math.abs(b);
        if (b==0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int getNume() {
        return this.numerator;
    }

    public void setNume(int p) {
        this.numerator = p;
    }

    public int getDeno() {
        return this.denominator;
    }

    public void setDeno(int q) {
        this.denominator = q;
    }

    public void printRational() {
        System.out.print(numerator);
        if (denominator == 1) {
            System.out.println();
            return;
        }
        System.out.println("/" + denominator);
    }

    public RationalNumber plus(RationalNumber b) {
        int gcd = gcd(this.denominator, b.denominator);
        return new RationalNumber(this.numerator*(b.denominator/gcd) + b.numerator*(this.denominator/gcd), 
            this.denominator*b.denominator/gcd);
    }

    public RationalNumber minus(RationalNumber b) {
        int gcd = gcd(this.denominator, b.denominator);
        return new RationalNumber(this.numerator*(b.denominator/gcd) - b.numerator*(this.denominator/gcd), 
            this.denominator*b.denominator/gcd);
    }

    public RationalNumber times(RationalNumber b) {
        return new RationalNumber(this.numerator*b.numerator, this.denominator*b.denominator);
    }

    public RationalNumber div(RationalNumber b) {
        return new RationalNumber(this.numerator*b.denominator, this.denominator*b.numerator);
    }

    public RationalNumber abs() {
        RationalNumber a = new RationalNumber(numerator, denominator);
        if (this.numerator < 0) a.numerator *= -1;
        if (this.denominator < 0) a.denominator *= -1;
        return a;
    }

}
