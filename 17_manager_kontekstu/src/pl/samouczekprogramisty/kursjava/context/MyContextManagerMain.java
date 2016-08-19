package pl.samouczekprogramisty.kursjava.context;

public class MyContextManagerMain {
    public static void main(String[] args) {
        try (MyContextManager manager = new MyContextManager()) {
            manager.doSomething();
        }
    }
}
