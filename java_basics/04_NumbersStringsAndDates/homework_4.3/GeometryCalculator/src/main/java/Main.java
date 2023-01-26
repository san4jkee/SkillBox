public class Main {
    public static void main(String[] args) {
        double radius = 20;
        System.out.println("Площать круга = " + GeometryCalculator.getCircleSquare(radius));

        System.out.println("Объем шара = " + GeometryCalculator.getSphereVolume(radius));

        double a = 1;
        double b = 20;
        double c = 30;

        System.out.println("Площадь треугольника = " +GeometryCalculator.getTriangleSquare(a,b, c));
    }
}
