package pl.samouczekprogramisty.kursjava.interfaces.figures;

public class Rectangle extends pl.samouczekprogramisty.kursjava.objects.Rectangle implements Figure {

    public Rectangle(double sideA, double sideB) {
        super(sideA, sideB);
    }

    public String getType() {
        return "rectangle";
    }
}
