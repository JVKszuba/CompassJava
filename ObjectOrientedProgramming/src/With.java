import java.util.Locale;
import java.util.Scanner;

public class With {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Triangle x, y;

        x = new Triangle();
        y = new Triangle();

        System.out.println("Enter the measures of triangle X: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Enter the measures of triangle Y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double areaX = x.calcArea();
        double areaY = y.calcArea();

        System.out.println("Triangle X area: " + areaX);
        System.out.println("Triangle Y area: " + areaY);

        if (areaX > areaY) System.out.println("Larger area: X");
        else if (areaY > areaX) System.out.println("Large area: Y");
        else System.out.println("Same area");
    }
}

class Triangle {

    public double a;
    public double b;
    public double c;

    public double calcArea() {

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}