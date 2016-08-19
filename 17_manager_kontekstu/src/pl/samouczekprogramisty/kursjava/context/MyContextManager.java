package pl.samouczekprogramisty.kursjava.context;

public class MyContextManager implements AutoCloseable {
    public MyContextManager() {
        System.out.println("Wlasnie sie tworze!");
    }

    public void doSomething() {
        System.out.println("Wlasnie cos robie :)");
    }

    public void close() {
        System.out.println("Ktos mnie teraz zamyka!");
    }
}
