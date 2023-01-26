import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {
    public static void addPhoneToName(String input) throws IOException {
        Set<String> nameWithPhones = phoneBook.getPhonesByName(input);
        if (nameWithPhones.size() == 0) {
            System.out.printf("Такого имени в телефонной книге нет.\n" +
                    "Введите номер телефона для абонента “%s”\n", input);
            String phone = consoleIn();
            if (phoneBook.phoneCorrect(phone)) {
                phoneBook.addContact(phone, input);
                System.out.println("Контакт сохранен!\n");
            } else {
                System.out.println("Введен некорректный телефон");
            }

        } else {
            nameWithPhones.forEach(System.out::println);
        }
    }

    public static void addNameToPhone(String input) throws IOException {
        String nameWithPhones = phoneBook.getNameByPhone(input);
        if (nameWithPhones.isEmpty()) {
            System.out.printf("Такого номера нет в телефонной книге.\n" +
                    "Введите имя абонента для номера “%s”\n", input);
            String name = consoleIn();
            if (phoneBook.nameCorrect(name)) {
                phoneBook.addContact(input, name);
                System.out.println("Контакт сохранен!\n");
            } else {
                System.out.println("Введено некорректное имя");
            }

        } else {
            System.out.println(nameWithPhones);
        }
    }
    public static String consoleIn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static void getAllContacts() {
        phoneBook.getAllContacts().forEach(System.out::println);
    }

    public static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) throws IOException {
        while (true){
            System.out.println("Введите номер телефона");
            String input = consoleIn();

            if (phoneBook.isCommand(input)) {
                getAllContacts();
                continue;
            }

            if (phoneBook.phoneCorrect(input)) {
                addNameToPhone(input);
                continue;
            }

            if (phoneBook.nameCorrect(input)) {
                addPhoneToName(input);
                continue;
            }

            System.out.println("Неверный формат ввода");
        }
    }
}
