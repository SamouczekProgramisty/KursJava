package pl.samouczekprogramisty.kursjava.interfaces.figures;


public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String getType() {
        return "circle";
    }
}
