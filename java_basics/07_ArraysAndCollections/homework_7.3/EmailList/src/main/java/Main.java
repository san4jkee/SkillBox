import java.util.*;

public class Main {

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        TreeSet<String> mailList = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие и введите одну из команд: ADD, LIST, EXIT");
        
        while (true) {
            String input = scanner.nextLine();
            String[] text = input.split("\\s+");
            String emails = text[0];
            if (input.equals("0")) {
                break;
            }
            
            //TODO: write code here
            final String ADD;
            final String LIST;
            final String EXIT;

            switch (emails){
                case "ADD":
                    String[] result = input.split(" ", 2);
                    String todo = result[1];
                    mailList.add(todo.toLowerCase());
                    break;
                case "LIST":
                    for (String list : mailList){
                        System.out.println(list);
                    }
                    break;
                case "EXIT":
                    return;
            }
        }
    }
}
