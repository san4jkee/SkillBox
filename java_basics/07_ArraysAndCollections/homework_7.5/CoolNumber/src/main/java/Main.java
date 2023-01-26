import java.util.*;

public class Main {
    private static String[] letters = {"C", "M", "T", "B", "A", "P", "O", "H", "E", "Y"};
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        CoolNumbers.generateCoolNumbers().addAll(list);

        HashSet<String> set = new HashSet<>(list);
        TreeSet<String> set1 = new TreeSet<>(list);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String stateNumber = scanner.nextLine();
            long a = System.nanoTime();
            if (list.contains(stateNumber)) {
                System.out.println("Поиск перебором: номер найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            } else {
                System.out.println("Поиск перебором: номер не найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            }
            long b = System.nanoTime();
            if (Collections.binarySearch(list, stateNumber) == 0) {
                System.out.println("Бинарный поиск: номер найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            } else {
                System.out.println("Бинарный поиск: номер не найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            }
            long c = System.nanoTime();
            if (set.contains(stateNumber)) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            } else {
                System.out.println("Поиск в HashSet: номер не найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            }
            long d = System.nanoTime();
            if (set1.contains(stateNumber)) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            } else {
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            }
        }
    }
}
