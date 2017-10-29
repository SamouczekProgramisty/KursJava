package pl.samouczekprogramisty.kursjava.accessmodifiers.protected_keyword.different_package;

import pl.samouczekprogramisty.kursjava.accessmodifiers.protected_keyword.Pen;

public class BallPen extends Pen {

    protected String manufacturer;

    public BallPen(String color, String manufacturer) {
        super(color);
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return manufacturer + " " + color;
    }
}
