import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 06;
        int month = 12;
        int year = 1992;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        month -= 1;
        String birthDay = "";
        int countNumbers = 0;
        Date d = new Date();
        DateFormat dataFormat = new SimpleDateFormat(" - dd.MM.yyyy - E", Locale.ENGLISH);
        Calendar calendar = new GregorianCalendar(year, month, day);
        Date birthDate = calendar.getTime();
        while (!birthDate.after(d)) {
            birthDay += countNumbers + dataFormat.format(birthDate) + System.lineSeparator();
            calendar.add(Calendar.YEAR, +1);
            birthDate = calendar.getTime();
            countNumbers++;
        }
        return birthDay;
    }
}
