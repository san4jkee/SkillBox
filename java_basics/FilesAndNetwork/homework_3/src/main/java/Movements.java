import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movements {

    private final String getCsvFilenamePath;
    private double income = 0;
    private double expense = 0;
    private Map<String, Double> expenseList = new HashMap<>();
    public List<String> lines;

    public Movements(String pathMovementsCsv) {
        this.getCsvFilenamePath = pathMovementsCsv;
    }

    public void CalculateData(String input) {
        String[] columns = input.split(",", 8);
        double incomeTmp = Double.parseDouble(columns[6]);
        double expenseTmp = Double.parseDouble(columns[7].replaceAll("\\\"", "").replace(',', '.'));
        if (incomeTmp == 0) calculateExpense(columns[5], expenseTmp);
        else this.income += incomeTmp;
    }

    private void calculateExpense(String expenseName, double expense) {
        this.expense += expense;
        String[] transaction = expenseName.trim().split(" {3,}");
        String[] temp = transaction[1].split("/");
        String[] suppliesTemp = temp[temp.length - 1].split("\\\\");
        String supplies = suppliesTemp[suppliesTemp.length - 1];
        if (!expenseList.containsKey(supplies))
            expenseList.put(supplies, expense);
        else {
            double sum = expenseList.get(supplies);
            sum += expense;
            expenseList.put(supplies.trim(), sum);
        }
    }

    public void printData() {
        System.out.println("ДВИЖЕНИЕ ДЕНЕЖНЫХ СРЕДСТВ");
        System.out.printf("ОБЩИЕ ПОСТУПЛЕНИЕ НА СЧЕТ: %.2f руб\n", income);
        System.out.println("--------------------------------------------------");
        System.out.println("ТАБЛИЦА РАСХОДОВ:");

        for (String supplies : expenseList.keySet()) {
            System.out.printf("%-30s -----> %.2f %-10s\n", supplies, expenseList.get(supplies), "руб");
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("ОБЩИЙ РАСХОД: %.2f руб", expense);
    }

    public double getIncomeSum() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/test/resources/movementList.csv"));
            for (int i = 1; i < lines.size(); i++) {
                String[] columns = lines.get(i).split(",", 8);
                income += Double.parseDouble(columns[6]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return income;
    }

    public double getExpenseSum() {
        try {
            lines = Files.readAllLines(Paths.get(getCsvFilenamePath));
            for (int i = 1; i < lines.size(); i++) {
                String[] columns = lines.get(i).split(",", 8);
                expense += Double.parseDouble(columns[7].replaceAll("\"", "")
                        .replace(',', '.'));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expense;
    }
}