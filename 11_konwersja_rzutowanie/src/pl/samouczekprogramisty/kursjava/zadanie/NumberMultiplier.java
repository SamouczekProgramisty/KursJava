package pl.samouczekprogramisty.kursjava.zadanie;

import java.util.Scanner;

public class NumberMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = PiMultiplier.getNumberFromUser(scanner);
        double number2 = PiMultiplier.getNumberFromUser(scanner);
        System.out.println(number1 / number2);
    }
}
