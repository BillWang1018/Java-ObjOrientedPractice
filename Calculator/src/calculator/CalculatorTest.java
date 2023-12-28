package calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addDigit('1');
        calc.addDigit('2');
        calc.selectOp('+');
        calc.addDigit('3');
        calc.addDigit('4');
        calc.equals();
        
        System.out.println(calc.getCur());
        System.out.println(calc.getAns());
        System.out.println(calc.getCur());
    }
}
