package pl.samouczekprogramisty.kursjava.generics;

public class GenericMethod {
    public <K> K add(K first, K second) {
        if (first == null) {
            return second;
        }
        return first;
    }

    public static <K> void print(K arg1, K arg2) {
        System.out.println(arg1);
        System.out.println(arg2);
    }
}
