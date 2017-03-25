package pl.samouczekprogramisty.kursjava.inheritance.cars;


public class Car extends Vehicle {
    private static final int NUMBER_OF_WHEELS = 4;
    protected int canUse = 10;
    private int cantUse = 11;

    public Car(Engine engine) {
        super(engine, NUMBER_OF_WHEELS);
    }

    public final void startEngine() {
        super.startEngine();
        System.out.println("Force driver to fasten seat belts.");
    }
}
