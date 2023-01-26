import java.sql.*;

public class Main {

    private final static String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
    private final static String user = "root";
    private final static String pass = "cFepN4";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, " +
                    "COUNT(*) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) " +
                    "AS average_count " +
                    "FROM purchaseList " +
                    "WHERE YEAR(subscription_date) = 2018 " +
                    "GROUP BY course_name");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String averageValue = resultSet.getString("average_count");
                System.out.println(courseName + " - " + averageValue);
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

    }
}
