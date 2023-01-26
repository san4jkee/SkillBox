import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";
    private static String deteFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();

        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });

        for (Employee employee: staff){
            System.out.println(employee);
        }
    }

    private static ArrayList<Employee> loadStaffFromFile() {
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.

        /*Collections.sort(staff, (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        Collections.sort(staff, (o1, o2) -> {
            return o1.getSalary().compareTo(o2.getSalary());
        });*/

        staff.sort((p1, p2) -> {
            if (p1.getSalary().compareTo(p2.getSalary()) == 0) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return p1.getSalary().compareTo(p2.getSalary());
            }
        });

        for (Employee employee : staff){
            System.out.println(employee);
        }

    }
}