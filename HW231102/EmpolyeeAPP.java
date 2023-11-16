package HW231102;

public class EmpolyeeAPP {
    public static void main(String[] args) {
        BasePlusCommissionEmpolyee bpce = new BasePlusCommissionEmpolyee("Tom", "Paul");
        bpce.setBaseSalary(1000);
        bpce.setCommissionRate(20);
        bpce.setGrossSales(30);
        bpce.setSSN("J123456789");

        bpce.print();
        System.out.printf("total salary: %.1f", bpce.earnings());
    }
}
