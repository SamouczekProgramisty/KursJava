package pl.samouczekprogramisty.kursjava.exercise;

/**
 * Created by mapi on 15.12.15.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Computation computation;

        if (main.shouldMultiply()) {
        //    computation = new Multiplication(); // zaimplementuj brakującą klasę
        }
        else {
        //    computation = new Addition(); // zaimplementuj brakującą klasę
        }

        double argument1 = main.getArgument();
        double argument2 = main.getArgument();

        //double result = computation.compute(argument1, argument2);
        //System.out.println("Wynik: " + result);
    }

    private boolean shouldMultiply() {
        return false; // tutaj zapytaj użytkownika co chce zrobić (mnożenie czy dodawanie)
    }

    private double getArgument() {
        return 0; // tutaj pobierz liczbę od użytkownika
    }
}
