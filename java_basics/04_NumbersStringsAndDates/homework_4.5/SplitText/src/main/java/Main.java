public class Main {

  public static void main(String[] args) {
    System.out.println(splitTextInToWords(null));
  }

  public static String splitTextInToWords(String text) {
    //TODO реализуйте метод

    String[] word = text.split("\\s|,|!|;|-|[0-9]| |\\.");
    String result = word[0];

    for(int i = 1; i < word.length; i++) {
      if(word[i] != null && !word[i].equals("")) {
        result += "\n" + word[i];
      }
    }
    return result;
  }

}