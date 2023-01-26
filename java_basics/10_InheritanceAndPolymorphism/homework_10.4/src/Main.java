import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 180; i++){
            company.hire(new Operator(30000));
        }
        for (int i = 0; i < 80; i++){
            workers.add(new Manager(40000));
        }
        for (int i = 0; i < 10; i++){
            workers.add(new TopManager(50000, company));
        }
        company.hireAll(workers);
        System.out.println(company.getIncome());

        printEmployees(company);
        System.out.println(company.getIncome());
        System.out.println("==================================");

        List<Employee> employees = company.getEmployees();
        int size = employees.size();
        System.out.println("Всего сотрудников: " + size);
        for (int i = 0; i < size; i++){
            company.fire(employees.get(i/2));
        }
        System.out.println("Осталось сотрудников после увольнения: " + company.getEmployees().size());
        System.out.println("==================================");
        printEmployees(company);
    }

    private static void printEmployees(Company company) {
        System.out.println("10 самых высоких зарплат в компании.");
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(10);
        for (Employee e : topSalaryStaff){
            System.out.println(e.getMonthSalary());
        }
        System.out.println("==================================");

        System.out.println("30 самых низких зарплат в компании.");
        List<Employee> lowSalaryStaff = company.getLowestSalaryStaff(30);
        for (Employee e : lowSalaryStaff){
            System.out.println(e.getMonthSalary());
        }
    }
}
