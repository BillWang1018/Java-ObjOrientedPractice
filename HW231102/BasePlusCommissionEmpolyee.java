package HW231102;

public class BasePlusCommissionEmpolyee extends Empolyee {
    
    public BasePlusCommissionEmpolyee(String first, String last) {
        super(first, last);
    }

    @Override
    double earnings() {
        return getCommissionRate() * getGrossSales() + getBaseSalary();
    }

    @Override
    void print() {
        System.out.printf("based-salaried commission employee: %s %s\n", getFirstName(), getLastName());
        System.out.printf("social security number: %s\n", getSSN());
        System.out.printf("gross sales: %d\n", getGrossSales());
        System.out.printf("commission rate: %d\n", getCommissionRate());
        System.out.printf("base salary: %d\n", getBaseSalary());
    }
}
