import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner1;
    private static Scanner scanner2;
    public static void main(String[] args) {
        System.out.println("Введите путь до папки для копирования:");
        scanner1 = new Scanner(System.in);
        String source = scanner1.next();
        String srcDir = source;

        System.out.println("Введите путь куда скопировать папку");
        scanner2 = new Scanner(System.in);
        String destination = scanner2.next();
        String destDir = destination;

        try {
            FileUtils.copyFolder(srcDir, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
