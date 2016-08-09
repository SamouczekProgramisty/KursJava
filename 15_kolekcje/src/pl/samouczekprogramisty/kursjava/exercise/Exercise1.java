package pl.samouczekprogramisty.kursjava.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise1 {

    public static final String NO_MORE_NAMES = "-";

    public static void main(String[] args) {
        String name;
        Set<String> names = new HashSet<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Podaj imie: ");
            name = input.next();
            if (!name.equals(NO_MORE_NAMES)) {
                names.add(name);
            }
        } while (!name.equals(NO_MORE_NAMES));


        System.out.println("Wprowadziles " + names.size() + " unikalnych imion.");
    }
}
