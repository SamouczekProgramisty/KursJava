package pl.samouczekprogramisty.kursjava.generics;

import pl.samouczekprogramisty.kursjava.generics.extendexample.Circle;
import pl.samouczekprogramisty.kursjava.generics.extendexample.Figure;
import pl.samouczekprogramisty.kursjava.generics.extendexample.Rectangle;
import pl.samouczekprogramisty.kursjava.generics.extendexample.Square;
import pl.samouczekprogramisty.kursjava.generics.genericinteritance.FancyBox;

public class WildcardExamples {

    public static void main(String[] args) {
        plainWildcard();
        upperBoundWildcard();
        lowerBoundWildcard();
    }

    private static void method1(FancyBox<?> box) {
        Object object = box.object;
        System.out.println(object);
    }

    private static void plainWildcard() {
        method1(new FancyBox<>(new Object()));
        method1(new FancyBox<>(new Square()));
        method1(new FancyBox<>(new Apple()));
    }

    private static void method2(FancyBox<? extends Figure> box) {
        Figure figure = box.object;
        System.out.println(figure);
    }

    private static void method3(FancyBox<Figure> box) {
        Figure figure = box.object;
        System.out.println(figure);
    }

    private static void upperBoundWildcard() {
        method2(new FancyBox<>(new Square()));
        method2(new FancyBox<>(new Circle()));
        //method3(new FancyBox<Square>(new Square())); // compilation error
    }

    private static void method4(FancyBox<? super Rectangle> box) {
        box.object = new Square();
        box.object = new Rectangle();
        //box.object = new Circle(); // compilation error
    }

    private static void lowerBoundWildcard() {
        method4(new FancyBox<Rectangle>(new Rectangle()));
        method4(new FancyBox<Figure>(new Rectangle()));
        method4(new FancyBox<Object>(new Object()));
        //method4(new FancyBox<Square>(new Square())); // compilation error
    }

}
