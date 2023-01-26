public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    System.out.println(container.count);

    int sum = sumDigits(7843);

    System.out.println(sum);
    
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

  public static int sumDigits(Integer number) {
    String s = Integer.toString(number);
    Integer sum = 0;
    if (sum == null){
      return -1;
    }
    /*for(int i = 0; i < s.length(); i++){
      sum += Integer.parseInt(String.valueOf(s.charAt(i)));
    }*/
    char[] charNumber = s.toCharArray();
    for(int i = 0; i < charNumber.length; i++){
      sum = sum + Character.getNumericValue(charNumber[i]);
    }
    return sum;
  }
}
