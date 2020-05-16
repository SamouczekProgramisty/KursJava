package pl.samouczekprogramisty.kursjava.primitivetypes.exercise;

import java.util.Scanner;

public class Excercise {

    private int[][] notes;

    public Excercise(int numberOfClasses, int numberOfNotes) {
        notes = new int[numberOfClasses][numberOfNotes];
    }

    public void getNotesFromUser() {
        Scanner scanner = new Scanner(System.in);
        for (int classIndex = 0; classIndex < notes.length; classIndex++) {
            for (int noteIndex = 0; noteIndex < notes[classIndex].length; noteIndex++) {
                System.out.println("Podaj ocenę numer " + (noteIndex + 1) + " dla przedmiotu numer " + (classIndex + 1) + ": ");
                notes[classIndex][noteIndex] = scanner.nextInt();
            }
        }
    }

    public void printAverate() {
        float totalAverage = 0;
        for (int classIndex = 0; classIndex < notes.length; classIndex++) {
            float classAverage = 0;
            for (int note : notes[classIndex]) {
                classAverage += note;
            }
            classAverage /= notes[classIndex].length;
            System.out.println("Średnia dla przedmiotu numer " + (classIndex + 1) + " wynosi: " + classAverage);
            totalAverage += classAverage;
        }
        totalAverage /= notes.length;
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
