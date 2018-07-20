package pl.samouczekprogramisty.kursjava.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class CustomSerialization implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient int someField;
    private String otherField;

    public CustomSerialization(int someField, String otherField) {
        this.someField = someField;
        this.otherField = otherField;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CustomSerialization writtenObject = new CustomSerialization(10, "something");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("custom-serialization.bin"))) {
            outputStream.writeObject(writtenObject);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("custom-serialization.bin"   ))) {
            CustomSerialization readObject = (CustomSerialization) inputStream.readObject();
            System.out.println(readObject.someField);
            System.out.println(readObject.otherField);
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        someField = stream.readInt();
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(someField + 1000);
    }
}
