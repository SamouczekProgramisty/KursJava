package pl.samouczekprogramisty.kursjava.interfaces.inheritance;

/**
 * Created by mapi on 15.12.15.
 */
public class Garfield implements FatCat {

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLasagnaRecipe() {
        return null;
    }

    public static void main(String[] args) {
        Cat cat = new Garfield();
        LasagnaEater lasagnaEater = new Garfield();
        FatCat fatCat = new Garfield();
        Garfield garfield = new Garfield();
    }
}
