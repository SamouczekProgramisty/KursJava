package pl.samouczekprogramisty.kursjava.files.exercise;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj sciezke pliku wejsciowego: ");
        String filePath = input.nextLine();
        DataInputStream inputFile = null;
        int birthDay = 0;
        int birthMonth = 0;
        int birthYear = 0;

        try {
            inputFile = new DataInputStream(new FileInputStream(filePath));
            birthDay = inputFile.readInt();
            birthMonth = inputFile.readInt();
            birthYear = inputFile.readInt();
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
        }

        System.out.println("Data urodzenia to " + birthDay + "." + birthMonth + "." + birthYear + ".");
    }
}
