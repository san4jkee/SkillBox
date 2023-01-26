import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailList {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    List<String> emailList = new ArrayList<>();

    public void add(String email) {
        if (!validate(email)){
            System.out.println(Main.WRONG_EMAIL_ANSWER);
            return;
        }
        String emailLowerCase = email.toLowerCase();
        if (!emailList.contains(emailLowerCase)) {
            emailList.add(emailLowerCase);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        Collections.sort(emailList);
        return new ArrayList<>(emailList);
    }

}
