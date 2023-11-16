package HW231102;

public class SalariedEmpolyee extends Empolyee {

    public SalariedEmpolyee(String first, String last) {
        super(first, last);
    }

    @Override
    double earnings() {
        return getWeeklySalary();
    }

    @Override
    void print() {
        System.out.printf("salaried employee: %s %s\n", getFirstName(), getLastName());
        System.out.printf("social security number: %s\n", getSSN());
        System.out.printf("weekly salary: %d\n", getWeeklySalary());
    }
    
}