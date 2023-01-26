public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль

    int sum = 0;

    for(int i = 0; i <= text.length() - 1; i++){
      if(Character.isDigit(text.charAt(i)) && !Character.isDigit(text.charAt(i - 1))){
        sum = sum + Integer.parseInt(text.substring(i, i + text.substring(i).indexOf(" ")).trim());
      }
    }
    System.out.println(sum);
  }
}