import com.skillbox.airport.Airport;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();

        System.out.println("All aircrafts: " + airport.getAllAircrafts().size());


    }
}
