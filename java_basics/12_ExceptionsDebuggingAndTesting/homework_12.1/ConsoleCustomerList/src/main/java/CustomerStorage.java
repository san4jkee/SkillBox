import junit.framework.AssertionFailedError;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    public boolean phoneCorrect(String name) {
        Pattern phonePattern = Pattern.compile("^\\+?[7-8][0-9]{10}");
        Matcher matcher = phonePattern.matcher(name);

        return matcher.matches();
    }

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws AssertionFailedError {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

        if (components.length != 4){
            throw new AssertionFailedError("Введены не все данные");
        }
        if (!validate(components[INDEX_EMAIL])){
            throw new AssertionFailedError("Неверный формат email");
        }
        if (!phoneCorrect(components[INDEX_PHONE])){
            throw new AssertionFailedError("Неверный формат номера");
        }

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}