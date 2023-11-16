package HW231102;

public class CommissionEmpolyee extends Empolyee {

    public CommissionEmpolyee(String first, String last) {
        super(first, last);
    }

    @Override
    double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    @Override
    void print() {
        System.out.printf("commission employee: %s %s\n", getFirstName(), getLastName());
        System.out.printf("social security number: %s\n", getSSN());
        System.out.printf("gross sales: %d\n", getGrossSales());
        System.out.printf("commission rate: %d\n", getCommissionRate());
    }
    
}
