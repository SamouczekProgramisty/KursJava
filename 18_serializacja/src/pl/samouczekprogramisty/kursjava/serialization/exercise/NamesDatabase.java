package pl.samouczekprogramisty.kursjava.serialization.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NamesDatabase {
    private static final String STOP = "-";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("names.db"))) {
            output.writeObject(getNamesFromUser());
        }
        List<String> names = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("names.db"))) {
            names = (List<String>) input.readObject();
        }
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static List<String> getNamesFromUser() throws IOException {
        Scanner input = new Scanner(System.in);
        String name = null;
        List<String> names = new LinkedList<>();
        while (true) {
            System.out.println("Podaj imie: ");
            name = input.nextLine();
            if (name.equals(STOP)) {
                break;
            }
            names.add(name);
        }
        return names;
    }
}
