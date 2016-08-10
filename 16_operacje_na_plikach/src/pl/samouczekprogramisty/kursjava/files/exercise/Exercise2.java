package pl.samouczekprogramisty.kursjava.files.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        BufferedReader inputFile = null;
        int numberOfLines = 0;
        String line;

        System.out.println("Podaj sciezke pliku wejsciowego: ");
        try {
            inputFile = new BufferedReader(new FileReader(input.next()));
            System.out.println("Zawartosc pliku: ");

            while (true) {
                line = inputFile.readLine();
                if (line == null) {
                    break;
                }
                numberOfLines++;
                System.out.println(line);
            }
        }
        finally {
            if (inputFile != null) {
                inputFile.close();
            }
        }
        System.out.println("Plik ma " + numberOfLines + " linii.");
    }
}
