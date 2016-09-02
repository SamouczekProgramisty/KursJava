package pl.samouczekprogramisty.kursjava.serialization.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class Human implements Serializable {
    private String name;
    private transient int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("age.bin"))) {
            output.writeObject(new Human("Piotrek", 23));
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("age.bin"))) {
            Human human = (Human) input.readObject();
            System.out.println(human.name);
            System.out.println(human.age);
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int birthYear = stream.readInt();
        age = Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        int birthYear = Calendar.getInstance().get(Calendar.YEAR) - age;
        stream.writeInt(birthYear);
    }
}
