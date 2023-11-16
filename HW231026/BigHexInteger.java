package HW231026;

import java.math.BigInteger;

public class BigHexInteger extends BigInteger{
    // Constructor 
    public BigHexInteger(String val) {
        super(val, 16);
    }
    // Hex -> Dec
    public BigInteger toBigInteger() {
        // return super.add(new BigInteger("0"));
        return new BigInteger(super.toString(10));
    }
    //+-*/
    public BigHexInteger add(Object val) {
        if(val instanceof BigInteger) {
            return new BigHexInteger(this.toBigInteger().add(BigInteger.class.cast(val)).toString(16));
        } else if(val instanceof BigHexInteger) {
            return new BigHexInteger(this.toBigInteger().add(BigHexInteger.class.cast(val).toBigInteger()).toString(16));
        }
        return new BigHexInteger("0");
    }
    public BigHexInteger subtract(Object val) {
        if(val instanceof BigInteger) {
            return new BigHexInteger(this.toBigInteger().subtract(BigInteger.class.cast(val)).toString(16));
        } else if(val instanceof BigHexInteger) {
            return new BigHexInteger(this.toBigInteger().subtract(BigHexInteger.class.cast(val).toBigInteger()).toString(16));
        }
        return new BigHexInteger("0");
    }
    public BigHexInteger multiply(Object val) {
        if(val instanceof BigInteger) {
            return new BigHexInteger(this.toBigInteger().multiply(BigInteger.class.cast(val)).toString(16));
        } else if(val instanceof BigHexInteger) {
            return new BigHexInteger(this.toBigInteger().multiply(BigHexInteger.class.cast(val).toBigInteger()).toString(16));
        }
        return new BigHexInteger("0");
    }
    public BigHexInteger divide(Object val) {
        if(val instanceof BigInteger) {
            return new BigHexInteger(this.toBigInteger().divide(BigInteger.class.cast(val)).toString(16));
        } else if(val instanceof BigHexInteger) {
            return new BigHexInteger(this.toBigInteger().divide(BigHexInteger.class.cast(val).toBigInteger()).toString(16));
        }
        return new BigHexInteger("0");
    }
    
    public String toString() {
        return super.toString(16).toUpperCase();
    }
    public String toBigIntegerString(int radix) {
        return super.toString(radix);
    }
    
}
