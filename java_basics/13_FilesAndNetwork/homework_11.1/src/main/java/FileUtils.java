import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static long calculateFolderSize(String path) {
            long result = 0;

            try {
                final File folder = new File(path);
                for (final File file : folder.listFiles()) {
                    if (file.isDirectory()) {
                        result += calculateFolderSize(file.getAbsolutePath());
                    } else {
                        result += Files.size(Path.of(file.getPath()));
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return result;
        }

}
