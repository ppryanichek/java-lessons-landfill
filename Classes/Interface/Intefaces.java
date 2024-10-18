
import java.util.Locale;

interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}

public class Intefaces {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Circle circle = new Circle(3.5);
        Rectangle rectangle = new Rectangle(4, 6.2);
        
        System.out.println(String.format("Circle area: %.3f", circle.area()));
        System.out.println("Rectangle area: " + rectangle.area());
    }
}
