package pl.samouczekprogramisty.kursjava.zadanie;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PiMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = getNumberFromUser(scanner);
        System.out.println(number * Math.PI);
        System.out.println((int) (number * Math.PI));
    }

    public static int getNumberFromUser(Scanner scanner) {
        System.out.println("Podaj liczbę całkowitą");
        while(true) {
            try {
                return scanner.nextInt();
            }
            catch (NoSuchElementException | IllegalStateException exception) {
                System.out.println("Wpwowadziłeś niepoprawną liczbę, spróbuj jeszcze raz...");
                scanner.next();
            }
        }
    }
}
