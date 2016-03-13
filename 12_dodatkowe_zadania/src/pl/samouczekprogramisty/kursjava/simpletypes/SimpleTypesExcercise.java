package pl.samouczekprogramisty.kursjava.simpletypes;

import pl.samouczekprogramisty.kursjava.loops.LoopsExcercises;

import java.util.Scanner;

public class SimpleTypesExcercise {
    public static void main(String[] args) {
        // printBinaryEnteredByUser();
        instantiateArray();
    }

    private static void printBinaryEnteredByUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe calkowita");
        LoopsExcercises.printBinary(scanner.nextInt());
    }

    private static void instantiateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj długość tablicy");
        int arrayLenght = scanner.nextInt();
        int[] numbers = new int[arrayLenght];
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Podaj liczbę na " + (i + 1) + " element tablicy");
            numbers[i] = scanner.nextInt();
        }
        LoopsExcercises.bubbleSort(numbers);
        LoopsExcercises.printArray(numbers);
    }

}
