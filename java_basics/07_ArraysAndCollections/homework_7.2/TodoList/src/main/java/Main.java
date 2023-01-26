import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> toDoList = new ArrayList<>() {{
        add("buy milk");
        add("buy tea");
        add("buy coffee");
        add("buy bread");
    }};

    public static void main(String[] args) {
        final String ADD;
        final String EDIT;
        final String DELETE;
        final String LIST;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие и введите одну из комманд: \n ADD \n EDIT \n DELETE \n LIST");

        while (true){
            String text = scanner.nextLine();
            String[] input = text.split("\\s+");
            String deals = input[0];
            String deed = "";
            int index = 0;
            switch (deals){
                case "ADD":
                    String[] result = text.split(" ", 2);
                    String todo = result[1];
                    toDoList.add(todo);
                    System.out.println("Добавлено дело " + "\"" + todo + "\"");
                    break;

                case "EDIT":
                    if (index > -1 && index < toDoList.size()) {
                        toDoList.set(index, deed);
                        System.out.println("Работа под индексом " + index + " изменена на \"" + deed + "\"");
                    } else {
                        System.out.println("Неверная команда. Укажите индекс редактируемого дела" +
                                " значением не более " + (toDoList.size() - 1));
                    }
                    break;

                case "DELETE":
                    if (index > -1 && index < toDoList.size()) {
                        toDoList.remove(index);
                        System.out.println("Работа с индексом " + index + " удалена");
                    } else {
                        System.out.println("Неверная команда. Укажите индекс удаляемого дела" +
                                " значением не более " + (toDoList.size() - 1));
                    }
                    break;

                case "LIST":
                    for (int i = 0; i < toDoList.size(); i++) {
                        System.out.println( i + " - " + toDoList.get(i));
                    }
                    break;
                case ("EXIT"):
                    System.out.println("Работа завершена.");
                    System.exit(0);
            }

        }
    }
}