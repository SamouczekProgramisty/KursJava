package pl.samouczekprogramisty.kursjava.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StaticSerialization implements Serializable{
    private static final long serialVersionUID = 1L;

    public static int someField = 100;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        firstExecution();
        secondExecution();
    }

    private static void secondExecution() throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("static.bin"))) {
            StaticSerialization otherObject = (StaticSerialization) input.readObject();
            System.out.println(otherObject.someField);
        }
    }

    private static void firstExecution() throws IOException {
        StaticSerialization object = new StaticSerialization();
        object.someField = 200;
        System.out.println(object.someField);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("static.bin"))) {
            output.writeObject(object);
        }
    }
}
