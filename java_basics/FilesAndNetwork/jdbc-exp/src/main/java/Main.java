import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=Europe/Moscow";
        String user = "root";
        String pass = "cFepN4";

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            statement.execute("UPDATE Courses SET name='Р’РµР±-СЂР°Р·СЂР°Р±РѕС‚С‡РёРє СЃ РЅСѓР»СЏ РґРѕ PRO' WHERE id = 1");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Students s \n" +
                    "\n" +
                    "WHERE MONTH(s.registration_date ) = 4;");
            while (resultSet.next()){
                String courseName = resultSet.getString("name");
                System.out.println(courseName);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
