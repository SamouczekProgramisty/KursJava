package pl.samouczekprogramisty.kursjava.interfaces.exercise;

import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        Computation computation;

        if (main.shouldMultiply()) {
            computation = new Multiplication();
        }
        else {
            computation = new Addition();
        }

        double argument1 = main.getArgument();
        double argument2 = main.getArgument();

        double result = computation.compute(argument1, argument2);
        System.out.println("Wynik: " + result);
    }

    private boolean shouldMultiply() {
        System.out.println("Jaka operacje chcesz wykonac? Napisz M jesli ma to byc mnozenie i nacisnij <Enter>. Mazdy inny wybor oznacza dodawanie.");
        return scanner.next().equals("M");
    }

    private double getArgument() {
        System.out.print("Podaj liczbe: ");
        return scanner.nextDouble();
    }
}
