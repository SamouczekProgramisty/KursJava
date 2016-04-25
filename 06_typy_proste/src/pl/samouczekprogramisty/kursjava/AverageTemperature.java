package pl.samouczekprogramisty.kursjava;

import java.util.Scanner;

/**
 * Created by mapi on 27.11.15.
 */
public class AverageTemperature {

    public static void main(String[] args) {
        double[] temperature = new double[7];
        Scanner inputScanner = new Scanner(System.in);

        for(int i = 0; i < temperature.length; i++) {
            System.out.println("Wprowadź liczbę " + i);
            temperature[i] = inputScanner.nextDouble();
        }

        double summarizedTemp = 0;
        for (double temp : temperature) {
            summarizedTemp += temp;
        }

        int numberOfClasses = 3;
        int numberOfNotes = 4;
        for (int classIndex = 0; classIndex < numberOfClasses; numberOfClasses++) {
            for (int noteIndex = 0; noteIndex < numberOfNotes; noteIndex++) {

            }
        }

        System.out.println("Średnia temperatura wynosi " + (summarizedTemp / temperature.length));
    }

}
