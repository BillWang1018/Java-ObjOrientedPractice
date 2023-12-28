package calculator;

import java.math.BigDecimal;

public class Calculator {
    char operator;
    BigDecimal ans, cur1, cur2;
    private StringBuilder tmp;

    protected Calculator() {
        operator = 0;
        ans = cur1 = cur2 = BigDecimal.ZERO;
        tmp = new StringBuilder();
    }

    protected double clear() {
        tmp.setLength(0);
        if (operator == 0)
            cur1 = BigDecimal.ZERO;
        else
            cur2 = BigDecimal.ZERO;

        return 0;
    }

    protected double allClear() {
        tmp.setLength(0);
        operator = 0;
        ans = cur1 = cur2 = BigDecimal.ZERO;

        return 0;
    }

    private BigDecimal strToCurrent() {
        if (operator == 0) {
            cur1 = new BigDecimal(tmp.toString());
            return cur1;
        }
        else {
            cur2 = new BigDecimal(tmp.toString());
            return cur2;
        }
    }

    protected BigDecimal getAns() {
        return ans;
    }
    protected BigDecimal getCur() {
        if (operator == 0)
            return cur1;
        else
            return cur2;
    }

    protected void addDigit(char c) {
        if (c != '.' || !hasDot())
            tmp.append(c);
        strToCurrent();
    }

    protected void persent() {
        cur1.divide(new BigDecimal(100));
        strToCurrent();
    }

    protected boolean hasDot() {
        for (int i=0; i<tmp.length(); i++) {
            if (tmp.charAt(i) == '.')
                return true;
        }
        return false;
    }

    protected void selectOp(char c) {
        operator = c;
        tmp.setLength(0);
    }

    protected void equals() {
        ans = cur1;
        switch (operator) {
            case '+':
                ans = ans.add(cur2);
                break;
            case '-':
                ans = ans.subtract(cur2);
                break;
            case '/':
                ans = ans.divide(cur2);
                break;
            case '*':
                ans = ans.multiply(cur2);
                break;
        }
        operator = 0;
        cur1 = ans;
    }
}
