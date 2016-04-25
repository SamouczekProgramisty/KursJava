package pl.samouczekprogramisty.kursjava;

import java.util.Scanner;

public class Excercise {

    private final int numberOfClasses;
    private final int numberOfNotes;
    private int[][] notes;

    public Excercise(int numberOfClasses, int numberOfNotes) {
        this.numberOfClasses = numberOfClasses;
        this.numberOfNotes = numberOfNotes;
        initializeNotes();
    }

    private void initializeNotes() {
        notes = new int[numberOfClasses][];
        for(int classIndex = 0; classIndex < notes.length; classIndex++) {
            notes[classIndex] = new int[numberOfNotes];
        }
    }

    public void getNotesFromUser() {
        Scanner scanner = new Scanner(System.in);
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            for (int noteIndex = 0; noteIndex < numberOfNotes; noteIndex++) {
                System.out.println("Podaj ocenę numer " + (noteIndex + 1) + " dla przedmiotu numer " + (classIndex + 1) + ": ");
                notes[classIndex][noteIndex] = scanner.nextInt();
            }
        }
    }

    public void printAverate() {
        float totalAverage = 0;
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            float classAverage = 0;
            for (int note : notes[classIndex]) {
                classAverage += note;
            }
            classAverage /= numberOfNotes;
            System.out.println("Średnia dla przedmiotu numer " + (classIndex + 1) + " wynosi: " + classAverage);
            totalAverage += classAverage;
        }
        totalAverage /= numberOfClasses;
        System.out.println("Średnia dla wszystkich przedmiotów wynosi: " + totalAverage);
    }

    public static void main(String[] args) {
        int numberOfClasses = 3;
        int numberOfNotes = 4;
        Excercise excercise = new Excercise(numberOfClasses, numberOfNotes);
        excercise.getNotesFromUser();
        excercise.printAverate();
    }

}
