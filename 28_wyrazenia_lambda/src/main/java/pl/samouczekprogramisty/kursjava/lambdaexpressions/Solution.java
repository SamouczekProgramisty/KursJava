package pl.samouczekprogramisty.kursjava.lambdaexpressions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        try (InputStream in = new FileInputStream("/home/mapi/Desktop/04_input.txt")) {
            Scanner scanner = new Scanner(in);
//            Scanner scanner = new Scanner(System.in);
            int howManyTests = scanner.nextInt();
            System.out.println(howManyTests);
            for (int testIndex = 0; testIndex < howManyTests; testIndex++) {
                int howManyBoxes = scanner.nextInt();
                long possibleMoves = 0;
                for (int boxIndex = 0; boxIndex < howManyBoxes; boxIndex++) {
                    int coinsInBox = scanner.nextInt();
                    possibleMoves += (boxIndex * coinsInBox) % 2;
                    possibleMoves %= 2;
                }
                if (possibleMoves == 0) {
                    System.out.println("First");
                }
                else if (possibleMoves % 2 == 0) {
                    System.out.println("Second");
                }
                else {
                    System.out.println("First");
                }
            }
        }

        System.out.println(3 / 2);
        System.out.println(3 % 2);
        System.out.println(4 / 2);
        System.out.println(4 % 2);
    }

}
