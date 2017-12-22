package pl.samouczekprogramisty.kursjava.inner;

public class OuterClass {
    public class InnerClass {
    }

    public enum InnerEnum {
    }

    public interface InnerInterface {
    }

    public InnerClass instantiate() {
        return new InnerClass();
    }
}
