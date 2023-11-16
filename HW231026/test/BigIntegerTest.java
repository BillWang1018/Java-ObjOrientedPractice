package HW231026.test;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String args[]) {
        BigInteger i1 = new BigInteger("124");
        BigInteger i2 = new BigInteger("1A", 16);
        System.out.println(i1.toString() + " + " + i2.toString(16) + " = " + i1.add(i2));
        System.out.println(i1.toString() + " + " + i2.toString(16) + " = " + i1.add(i2));
    }
}
