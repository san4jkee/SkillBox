import java.util.*;

public class CoolNumbers {
    public static List<String> generateCoolNumbers() {
        return generateOneNumber();
    }

    public static List<String> generateOneNumber(){
        final String[] carLetters = new String[] {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        Arrays.sort(carLetters);
        ArrayList<String> list = new ArrayList<>();
        for (String letter : carLetters) {
            for (int figure = 0; figure < 10; figure++) {
                for (String letter_2 : carLetters) {
                    for (String letter_3 : carLetters) {
                        for (int m = 1; m <= 199; m++) {
                            String numberCar = String.format("%s%d%d%d%s%s%d", letter, figure, figure, figure, letter_2, letter_3, m);
                            list.add(numberCar);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (int i = 0; i < number.length(); i++){
            if (list.contains(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number){
        int key = Collections.binarySearch(sortedList, number);
        if (key >= 0){
            return true;
        }else
        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        for (int i = 0; i < number.length(); i++) {
            if (hashSet.contains(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        for (int i = 0; i < number.length(); i++){
            if (treeSet.contains(number)){
                return true;
            }
        }
        return false;
    }
}