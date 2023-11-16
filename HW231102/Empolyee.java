package HW231102;

public abstract class Empolyee {
    private int weeklySalary;
    private int commissionRate;
    private int grossSales;
    private int baseSalary;
    private String firstName, lastName;
    private String SSN;

    abstract double earnings();
    abstract void print();

    public Empolyee(String first, String last) {
        this.firstName = first;
        this.lastName  = last;
    }
    public int getWeeklySalary() {
        return weeklySalary;
    }
    public void setWeeklySalary(int weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
    public int getCommissionRate() {
        return commissionRate;
    }
    public void setCommissionRate(int commissionRate) {
        this.commissionRate = commissionRate;
    }
    public int getGrossSales() {
        return grossSales;
    }
    public void setGrossSales(int grossSales) {
        this.grossSales = grossSales;
    }
    public int getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }public void setSSN(String sSN) {
        SSN = sSN;
    }
    public String getSSN() {
        return SSN;
    }
}
