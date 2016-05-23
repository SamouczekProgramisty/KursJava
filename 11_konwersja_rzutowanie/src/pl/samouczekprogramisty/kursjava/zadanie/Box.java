package pl.samouczekprogramisty.kursjava.zadanie;

public class Box<T> {
    private final T attribute;

    public Box(T attribute) {
        this.attribute = attribute;
    }

    public T getAttribute() {
        return attribute;
    }
}