package pl.samouczekprogramisty.kursjava.context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TriWithResourcesExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj sciezke pliku wejsciowego: ");
        String inputPath = input.nextLine();

        tryWithResourcesExample(inputPath);
        moreComplicatedExample(inputPath);
    }

    private static void moreComplicatedExample(String inputPath) {
        String outputPath = inputPath + ".backup";

        try(
                BufferedReader fileReader = new BufferedReader(new FileReader(inputPath));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputPath))
        ) {
            String line = fileReader.readLine();
            fileWriter.write(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tryWithResourcesExample(String inputPath) {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(inputPath));
            fileReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try(BufferedReader fileReader2 = new BufferedReader(new FileReader(inputPath))) {
            fileReader2.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
