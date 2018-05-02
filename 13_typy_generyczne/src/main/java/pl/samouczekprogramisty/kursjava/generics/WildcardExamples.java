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
        box.object = null;
        // box.object = new Square(); // compilation error
    }

    private static void method3(FancyBox<Figure> box) {
        Figure figure = box.object;
        System.out.println(figure);
    }

    private static void upperBoundWildcard() {
        FancyBox<Figure> fancyFigureBox = new FancyBox<>(new Circle());
        FancyBox<Circle> fancyCircleBox = new FancyBox<>(new Circle());
        FancyBox<Square> fancySquareBox = new FancyBox<>(new Square());
        method2(fancyFigureBox);
        method2(fancyCircleBox);
        method2(fancySquareBox);
        // method3(fancySquareBox); // compilation error
    }

    private static void method4(FancyBox<? super Rectangle> box) {
        box.object = null;
        box.object = new Rectangle();
        box.object = new Square();
        // box.object = new Object(); // compilation error
    }

    private static void lowerBoundWildcard() {
        FancyBox<Rectangle> fancyRectangleBox = new FancyBox<>(new Rectangle());
        FancyBox<Figure> fancyFiguraBox = new FancyBox<>(new Rectangle());
        FancyBox<Object> fancyObjectBox = new FancyBox<>(new Object());
        method4(fancyRectangleBox);
        method4(fancyFiguraBox);
        method4(fancyObjectBox);
        // FancyBox<Square> fancySquareBox = new FancyBox<>(new Square());
        // method4(fancySquareBox); // compilation error
    }

}
