import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class Company {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees(){
        return new ArrayList<>(employees);
    }

    public void hire(Employee employee){
        employee.setCompany(this);
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees){
        for (Employee e : employees){
            hire(e);
        }
    }

    public void fire(Employee employee){
        employee.setCompany(null);
        employees.remove(employee);
    }

    public int getIncome(){
        int income = 0;
        for (Employee e : employees){
            if (e instanceof Manager){
                income += ((Manager) e).getSales();
            }
        }
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count < 0){
            System.out.println("Передано неверное значение");
            return Collections.emptyList();
        }
        if (count < employees.size()){
            count = employees.size();
        }
        Collections.sort(employees);
        Collections.reverse(employees);
        ArrayList<Employee> result = new ArrayList<>();
        return employees.subList(0, count);
    }

    List<Employee> getLowestSalaryStaff(int count){
        if (count < 0){
            return Collections.emptyList();
        }
        if (count < employees.size()){
            count = employees.size();
        }
        Collections.sort(employees);
        return employees.subList(0, count);
    }
}
