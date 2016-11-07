package pl.samouczekprogramisty.kursjava.generics.extendexample;

public class Main {
    public static void main(String[] args) {
        compilationError();
        BoxForFigures<Triangle> triangleBox = new BoxForFigures<>(new Triangle());
        //BoxForFigures<Rectangle> rectangleBox = new BoxForFigures<>(new Rectangle());
        BoxForFigures<Square> squareBox = new BoxForFigures<>(new Square());

        compilationError2();
    }

    private static void compilationError2() {
        Rectangle rectangle = new Square();
        //BoxForFigures<Rectangle> rectangleBox = new BoxForFigures<Square>(new Square());
    }

    private static void compilationError() {
        BoxForFigures<Circle> circleBox = new BoxForFigures<>(new Circle());
        // BoxForFigures<Apple> appleBox; // complilation failure
    }
}
