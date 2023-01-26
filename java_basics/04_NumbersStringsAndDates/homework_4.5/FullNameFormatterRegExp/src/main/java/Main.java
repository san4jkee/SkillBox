import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      String[] count;
      Pattern p = Pattern.compile("\\d");
      Matcher m = p.matcher(input);
      if (m.find()) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      count = input.split(" ");
      if (count.length < 3){
        System.out.println("Введенная строка не является ФИО");
        break;
      }

      String firstName = input.split(" ")[0];
      String lastName = input.split(" ")[1];
      String otherName = input.split(" ")[2];

      System.out.println("Фамилия: " + firstName);
      System.out.println("Имя: " + lastName);
      System.out.println("Отчество: " + otherName);

    }
  }

}