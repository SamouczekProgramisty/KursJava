package pl.samouczekprogramisty.kursjava.generics;

import pl.samouczekprogramisty.kursjava.generics.genericinteritance.FancyBox;

public class Main {
    public static void main(String[] args) {
        AppleBox appleBox1 = new AppleBox(new Apple());
        OrangeBox orangeBox1 = new OrangeBox(new Orange());

        ObjectBox fruitBox = new ObjectBox(new Orange());
        Orange fruit1 = (Orange) fruitBox.getFruit();

        BoxOnSteroids<Apple> appleBox2 = new BoxOnSteroids<>(new Apple());
        BoxOnSteroids<Orange> orangeBox2 = new BoxOnSteroids<>(new Orange());

        Orange fruit2 = orangeBox2.getFruit();

        nestedGenerics();

        // genericClassCastException();

        genericMethods();
    }

    private static void nestedGenerics() {
        Pair<BoxOnSteroids<Orange>, BoxOnSteroids<Apple>> pairOfBoxes =
                new Pair<>(
                        new BoxOnSteroids<>(new Orange()),
                        new BoxOnSteroids<>(new Apple())
                );
    }

    @SuppressWarnings({"unchecked", "unused"})
    private static void genericClassCastException() {
        BoxOnSteroids boxWithoutType = new BoxOnSteroids(new Apple());
        BoxOnSteroids<Apple> boxWithApple = boxWithoutType;
        BoxOnSteroids<Orange> boxWithOrange = boxWithoutType;
        Apple apple = boxWithApple.getFruit();
        Orange orange = boxWithOrange.getFruit(); // ClassCastException

        System.out.println(boxWithApple.getFruit());
        System.out.println(boxWithOrange.getFruit());
    }

    @SuppressWarnings("unused")
    public static void compilationError() {
        FancyBox<?> box = new FancyBox<>("object");
        box.object = null;
        // box.object = "xxx"; // CompilationError
    }

    private static void genericMethods() {
        GenericMethod genericMethod = new GenericMethod();
        GenericMethod.print(1L, new Apple());
    }
}
