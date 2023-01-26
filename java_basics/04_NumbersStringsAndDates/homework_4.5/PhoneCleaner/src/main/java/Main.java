import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.

      String phone = input.replaceAll("[^0-9]", "").replaceAll("8{1}", "7");

      if (phone.length() >= 12 || phone.length() < 10){
        System.out.println("Неверный формат номера");
        break;
      } else if (phone.length() == 10) {
        System.out.println("7" + phone);
      } else if(phone.length() == 11 && !phone.startsWith("7") && !phone.startsWith("8")){
        System.out.println("Неверный формат номера");
        break;
      } else {
        System.out.println(phone);
      }
    }
  }
}
