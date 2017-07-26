package pl.samouczekprogramisty.kursjava.lambdaexpressions.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj 4 lancuchy znakow oddzielajac je znakiem nowej linii:");
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            strings.add(scanner.nextLine());
        }

        System.out.println(strings);
        strings.sort((a, b) -> b.length() - a.length());
        // strings.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(strings);
    }

}
