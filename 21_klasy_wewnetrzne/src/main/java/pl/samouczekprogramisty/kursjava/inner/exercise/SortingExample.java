package pl.samouczekprogramisty.kursjava.inner.exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SortingExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 5;
        List<String> words = new LinkedList<>();

        while(counter != 0) {
            System.out.println("Podaj slowo: ");
            words.add(input.next());
            counter--;
        }

        System.out.println("Przed sortowaniem: ");
        printList(words);
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return word1.length() - word2.length();
            }
        });
        System.out.println("Po sortowaniu: ");
        printList(words);
    }

    private static void printList(List<String> words) {
        for(String word : words) {
            System.out.println(word);
        }
    }

}
