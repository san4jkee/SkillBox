import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static String movementListFile = "data/movementList.csv";

    public static void main(String[] args) {

        DecimalFormat formatter = new DecimalFormat("0.00");
        ArrayList<Movements> movementList = loadMovementListFromFile();

        System.out.println("Сумма расходов: " + formatter.format(getExpenseSum(movementList)) + " руб.");
        System.out.println("Сумма доходов: " + formatter.format(getIncomeSum(movementList)) + " руб.");
        System.out.println("=================");

        System.out.println("Суммы расходов по организациям:");

        for (Map.Entry entry : getMapNameExpense(movementList).entrySet()) {
            System.out.println(entry.getKey() + " - " + formatter.format(entry.getValue()) + " руб.");
        }

    }

    private static ArrayList<Movements> loadMovementListFromFile() {

        ArrayList<Movements> movementList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(movementListFile));
            lines.remove(0);
            for (String line : lines) {
                List<String> lines1 = new ArrayList<>();
                String lineMovementList = line.replaceAll("(\\\")(\\d+)(,)(\\d+)(\\\")", "$2\\.$4")
                        .replaceAll("[(-)]", "");
                lines1.add(lineMovementList);
                for (String line1 : lines1) {
                    String[] fragments = line1.split(",");
                    if (fragments.length != 8) {
                        System.out.println("Wrong line: " + line);
                        continue;
                    }
                    String companyName = fragments[5]
                            .replaceAll("\\s\\d+\\.\\d+\\.\\d+\\s(.+)", "")
                            .replaceAll("\\d+\\++\\d+", "")
                            .replaceAll("^.+(\\\\|\\/)", "")
                            .replaceAll("\\>\\w+", "")
                            .trim();
                    BigDecimal income = new BigDecimal(fragments[6]);
                    BigDecimal expense = new BigDecimal(fragments[7]);

                    movementList.add(new Movements(
                            companyName,
                            income,
                            expense
                    ));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return movementList;
    }

    private static BigDecimal getExpenseSum(ArrayList<Movements> movementList) {
        List<BigDecimal> listExpense = new ArrayList<>();
        for (Movements bankAccount : movementList) {
            listExpense.add(bankAccount.getMoneySpending());
        }
        BigDecimal amountOfExpenses = new BigDecimal(0.0);
        for (int i = 0; i < listExpense.size(); i++) {
            amountOfExpenses = amountOfExpenses.add(new BigDecimal(String.valueOf(listExpense.get(i))));
        }
        return amountOfExpenses;
    }

    private static BigDecimal getIncomeSum(ArrayList<Movements> movementList) {
        List<BigDecimal> listIncome = new ArrayList<>();
        for (Movements bankAccount : movementList) {
            listIncome.add(bankAccount.getMoneyArrival());
        }
        BigDecimal amountOfIncome = new BigDecimal(0.0);
        for (int i = 0; i < listIncome.size(); i++) {
            amountOfIncome = amountOfIncome.add(new BigDecimal(String.valueOf(listIncome.get(i))));
        }
        return amountOfIncome;
    }

    private static HashMap<String, BigDecimal> getMapNameExpense(ArrayList<Movements> movementList) {

        HashMap<String, BigDecimal> mapNameExpense = new HashMap<>();
        movementList.stream()
                .collect(Collectors.toMap(Movements::getCompanyName
                        , Movements::getMoneySpending
                        , (bigDecimal, bigDecimal2) ->
                                (bigDecimal.add(new BigDecimal(String.valueOf(bigDecimal2))))))
                .forEach((s, bigDecimal) -> mapNameExpense.put(s, bigDecimal));
        return mapNameExpense;
    }

}