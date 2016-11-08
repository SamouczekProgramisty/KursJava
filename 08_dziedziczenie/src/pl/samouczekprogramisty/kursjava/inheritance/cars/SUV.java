package pl.samouczekprogramisty.kursjava.inheritance.cars;

class X {

}
public final class SUV extends Car {
    public SUV(Engine engine) {
        super(engine);
    }

    public static void main(String[] args) {
        System.out.println(new X());
    }
}
