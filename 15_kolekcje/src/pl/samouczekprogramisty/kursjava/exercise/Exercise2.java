package pl.samouczekprogramisty.kursjava.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Map<String, String> pairs = new HashMap<>();
        Scanner input = new Scanner(System.in);
        String name1, name2;

        while(true) {
            System.out.println("Podaj imie partnera: ");
            name1 = input.next();
            if (name1.equals("-")) {
                break;
            }
            System.out.println("Podaj imie partnerki: ");
            name2 = input.next();
            if (name2.equals("-")) {
                break;
            }
            pairs.put(name1, name2);
        }

        System.out.println("Podaj imie partnera do sprawdzenia: ");
        name1 = input.next();
        System.out.println("Partnerka dla " + name1 + " to " + pairs.get(name1));
    }
}
