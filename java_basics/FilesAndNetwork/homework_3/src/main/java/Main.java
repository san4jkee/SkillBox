import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final String CSVFilename = "movementList.csv";

    public static void main(String[] args) throws IOException {
        String pathToFile = Path.of(CSVFilename).toAbsolutePath().toString();
        Movements movements = new Movements(pathToFile);

        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/movementList.csv"));
        for (int i = 1; i < lines.size(); i++) {
            movements.CalculateData(lines.get(i));
        }

        movements.printData();
    }
}