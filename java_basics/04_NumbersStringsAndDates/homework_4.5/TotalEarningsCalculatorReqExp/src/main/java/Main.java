import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    System.out.printf("%d\n", calculateSalarySum(null));
  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    Pattern p = Pattern.compile("(\\d+)");
    Matcher m = p.matcher(text);

    Integer sum = 0;

    while(m.find()){
      sum += Integer.parseInt(m.group(1));
    }
    return sum;
  }

}