public class Main {
    public static void main(String[] args) {
        char k;

        for (char i = 'a'; i <= 'z'; i++){
            System.out.println(i + " - " + (int)i);
        }
        for(char j = 'A'; j <= 'Z'; j++){
            System.out.println(j + " - " + (int)j);
        }
        for(char rus = 'а'; rus <= 'я'; rus++){
            System.out.println(rus + " - " + (int)rus);
        }
        for(char rus1 = 'А'; rus1 <= 'Я'; rus1++){
            System.out.println(rus1 + " - " + (int)rus1);
        }
    }
}
