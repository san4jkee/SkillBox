public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * radius * radius;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return Math.abs(4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if(((b + c - a) > 0) && ((a + c - b) > 0) && ((a + b - c) > 0))
        {
            return true;
        }
        return false;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if((a <= 0 || b <= 0 || c <= 0) || (a <= 1 || b <= 1 || c <= 1))
        {
            return -1;
        }
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
