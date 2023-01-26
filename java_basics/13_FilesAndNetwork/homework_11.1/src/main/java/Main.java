import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Введите путь до папки:");
        scanner = new Scanner(System.in);

        String path = scanner.next();

        try {
            System.out.println("Размер папки " + path + " составляет " + Reports(path) + " Гб");
        } catch (NullPointerException ex){
            System.out.println("Введенная директория не найдена");
        }
    }

    private static double ConvertToGigaByte(long sizeToByte)
    {
        double kb = (double) sizeToByte / 1024D;
        double mb = kb / 1024D;
        double gb = mb / 1024D;
        return gb;
    }

    private static double Rounding(double val) {
        return ((double)Math.round(val*100))/100;
    }

    private static double Reports(String path){
        long sizeInByte = FileUtils.calculateFolderSize(path);
        double sizeInGb = ConvertToGigaByte(sizeInByte);
        double roundedGb = Rounding(sizeInGb);
        return roundedGb;
    }
}
