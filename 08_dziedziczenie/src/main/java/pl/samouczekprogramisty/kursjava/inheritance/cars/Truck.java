package pl.samouczekprogramisty.kursjava.inheritance.cars;

public class Truck extends Vehicle {
    private static final int NUMBER_OF_WHEELS = 12;

    public Truck(Engine engine) {
        super(engine, NUMBER_OF_WHEELS);
    }
}
