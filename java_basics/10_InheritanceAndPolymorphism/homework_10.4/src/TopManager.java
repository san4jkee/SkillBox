public class TopManager extends Worker{
    public static final int MIN_INCOME = 10000000;
    public static final double MULTIPLIER = 1.5;
    private Company company;

    public TopManager(int salary, Company company){
        super(salary);
        setCompany(company);
    }
    @Override
    public int getMonthSalary() {
        if (company.getIncome() > MIN_INCOME){
            return (int)(salary + salary * MULTIPLIER);
        }
        return salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }
}
