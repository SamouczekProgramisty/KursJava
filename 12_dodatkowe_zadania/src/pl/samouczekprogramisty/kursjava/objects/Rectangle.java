package pl.samouczekprogramisty.kursjava.objects;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getArea() {
        return sideA * sideB;
    }

    public double getPerimeter() {
        return 2 * sideA + 2 * sideB;
    }

    public double getDiagonal() {
        return Math.sqrt(sideA * sideA + sideB * sideB);
    }
}
