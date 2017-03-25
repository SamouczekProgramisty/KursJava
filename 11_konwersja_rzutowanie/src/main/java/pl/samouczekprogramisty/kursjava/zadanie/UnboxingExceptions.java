package pl.samouczekprogramisty.kursjava.zadanie;


public class UnboxingExceptions {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Box<?> box = new Box<>(new Object());
        Box<Integer> box2 = (Box<Integer>) box;
        int attribute = box2.getAttribute();
    }
}
