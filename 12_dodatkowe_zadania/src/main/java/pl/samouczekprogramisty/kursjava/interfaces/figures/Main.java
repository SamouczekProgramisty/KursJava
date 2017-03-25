package pl.samouczekprogramisty.kursjava.interfaces.figures;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[3];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj promień");
        figures[0] = new Circle(scanner.nextDouble());

        System.out.println("Podaj 2 boki trójkąta");
        figures[1] = new Triangle(scanner.nextDouble(), scanner.nextDouble());

        System.out.println("Podaj 2 boki prostokąta");
        figures[2] = new Rectangle(scanner.nextDouble(), scanner.nextDouble());

        for (Figure figure : figures) {
            System.out.println(figure.getType());
            System.out.println("pole " + figure.getArea());
            System.out.println("obwód " + figure.getPerimeter());
        }
    }
}
