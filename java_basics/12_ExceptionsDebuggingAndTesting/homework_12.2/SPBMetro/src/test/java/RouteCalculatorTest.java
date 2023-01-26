import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest  extends TestCase {
    List<Station> route;
    List<Station> connectors;
    List<Station> oneConnectionRoute;
    List<Station> twoConnectionsRoute;
    RouteCalculator routeCalculator;
    StationIndex stationIndex;
    Station firstLine1;
    Station secondLine1;
    Station thirdLine1;
    Station firstLine2;
    Station secondLine2;
    Station thirdLine2;
    Station firstLine3;
    Station secondLine3;
    Station thirdLine3;

    @Override
    protected void setUp() {
        stationIndex = new StationIndex();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        firstLine1 = new Station("Автово", line1);
        secondLine1 = new Station("Проспект Ветеранов", line1);
        thirdLine1 = new Station("Переходная на первой линии", line1);
        firstLine2 = new Station("Парнас", line2);
        secondLine2 = new Station("Купчино", line2);
        thirdLine2 = new Station("Переходная на второй линии", line2);
        firstLine3 = new Station("Беговая", line3);
        secondLine3 = new Station("Приморская", line3);
        thirdLine3 = new Station("Переходная на третьей линии", line3);

        line1.addStation(firstLine1);
        line1.addStation(secondLine1);
        line1.addStation(thirdLine1);
        line2.addStation(firstLine2);
        line2.addStation(secondLine2);
        line2.addStation(thirdLine2);
        line3.addStation(firstLine3);
        line3.addStation(secondLine3);
        line3.addStation(thirdLine3);

        connectors = new ArrayList<>();
        connectors.add(thirdLine1);
        connectors.add(thirdLine2);
        connectors.add(thirdLine3);

        route = new ArrayList<>();
        route.add(firstLine1);
        route.add(secondLine1);
        route.add(thirdLine1);


        stationIndex = new StationIndex();

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addConnection(connectors);
        stationIndex.addStation(firstLine1);
        stationIndex.addStation(secondLine1);
        stationIndex.addStation(thirdLine1);
        stationIndex.addStation(firstLine2);
        stationIndex.addStation(secondLine2);
        stationIndex.addStation(thirdLine2);
        stationIndex.addStation(firstLine3);
        stationIndex.addStation(secondLine3);
        stationIndex.addStation(thirdLine3);

        oneConnectionRoute = new ArrayList<>();
        oneConnectionRoute.add(firstLine1);
        oneConnectionRoute.add(secondLine1);
        oneConnectionRoute.add(thirdLine1);
        oneConnectionRoute.add(thirdLine2);
        oneConnectionRoute.add(secondLine2);

        twoConnectionsRoute = new ArrayList<>();
        twoConnectionsRoute.add(firstLine1);
        twoConnectionsRoute.add(secondLine1);
        twoConnectionsRoute.add(thirdLine1);
        twoConnectionsRoute.add(thirdLine2);
        twoConnectionsRoute.add(thirdLine3);
        twoConnectionsRoute.add(secondLine3);
        twoConnectionsRoute.add(firstLine3);

        routeCalculator = new RouteCalculator(stationIndex);
    }
    @DisplayName("Тест добавления корректных данных Customer")
    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expect = 5;
        assertEquals(expect, actual);
    }
    @DisplayName("Тест короткого маршрута")
    public void testGetShortestRoute(){
        List<Station> actual = routeCalculator.getShortestRoute(firstLine1, thirdLine1);
        assertEquals(route, actual);
    }
    @DisplayName("Тест маршрута на одной линии")
    public void testGetRouteOnTheLine(){
        List<Station> actual = routeCalculator.getShortestRoute(firstLine1, thirdLine1);
        assertEquals(route, actual);
    }
    @DisplayName("Тест маршрута с одной пересадкой")
    public void testGetRouteWithOneConnection(){
        double actual = RouteCalculator.calculateDuration(oneConnectionRoute);
        double expected = 11;
        assertEquals(expected, actual);
    }
    @DisplayName("Тест маршрута с двумя пересадками")
    public void testGetRouteWithTwoConnections(){
        double actual = RouteCalculator.calculateDuration(twoConnectionsRoute);
        double expected = 17;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception{

    }
}
