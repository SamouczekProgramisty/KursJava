package pl.samouczekprogramisty.kursjava.interfaces.figures;

public class Triangle implements Figure {
    private double a;
    private double b;
    private double hypotenuse;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.hypotenuse = Math.sqrt(a * a + b * b);
    }

    public double getPerimeter() {
        return a + b + hypotenuse;
    }

    public double getArea() {
        return a * b / 2;
    }

    public String getType() {
        return "triangle";
    }
}
