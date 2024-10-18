abstract class Shape {
    protected String color;

    abstract double area();

    public abstract String toString();

    public Shape(String color) {
        System.out.println("\"Shape consturctor\"");
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
        System.out.println("\"Circle consturcor\"");
    }

    @Override double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override public String toString() {
        return "Circle color is: " + color + String.format("\nCircle area is: %.3f", area());
    }
}

class Rectangle extends Shape
{
    private double length, width;

    Rectangle(String color, double length, double width){
        super(color);
        this.length = length;
        this.width = width;
        System.out.println("\"Rectangle constuctor\"");
    }

    @Override double area(){
        return length * width;
    }

    @Override public String toString(){
        return "Circle color is: " + super.color + String.format("\nCircle area is: %.3f", area());
    }
}

public class Inheritance
{
    public static void main(String[] args) throws ClassNotFoundException {
        Circle circle = new Circle("Red", 4);
        System.out.println(circle.toString());

        System.out.println("___________________");

        Rectangle rectangle = new Rectangle("Green", 10, 8);
        System.out.println(rectangle.toString());
    }
}