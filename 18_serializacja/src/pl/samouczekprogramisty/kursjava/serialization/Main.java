package pl.samouczekprogramisty.kursjava.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        simpleSerialization();
        graphSerialisation();
    }

    private static void graphSerialisation() throws IOException, ClassNotFoundException {
        Tyre[] tyres = new Tyre[] {new Tyre(16), new Tyre(16), new Tyre(16), new Tyre(16)};
        Engine engine = new Engine("some model");
        Car serializedCar = new Car(engine, tyres);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("object-graph.bin"))) {
            outputStream.writeObject(serializedCar);
        }

        Car deserializedCar = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("object-graph.bin"))) {
            deserializedCar = (Car) inputStream.readObject();
            System.out.println(deserializedCar.getEngine().getModel());
            System.out.println(deserializedCar.getTyres().length);
        }

        System.out.println(serializedCar == deserializedCar);
    }

    private static void simpleSerialization() throws IOException, ClassNotFoundException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("objects.bin"))) {
            outputStream.writeObject(Integer.valueOf(1));
            outputStream.writeObject(Integer.valueOf(2));
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("objects.bin"))) {
            Integer number = (Integer) inputStream.readObject();
            System.out.println(number);
            number = (Integer) inputStream.readObject();
            System.out.println(number);
        }
    }
}
