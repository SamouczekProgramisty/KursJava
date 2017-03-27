package pl.samouczekprogramisty.kursjava.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class CustomProtocolSerialization implements Externalizable {
    private String field;

    public CustomProtocolSerialization() {
    }

    public CustomProtocolSerialization(String field) {
        this.field = field;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CustomProtocolSerialization object = new CustomProtocolSerialization("field value");

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("externalizable.bin"))) {
            output.writeObject(object);
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("externalizable.bin"))) {
            CustomProtocolSerialization readObject = (CustomProtocolSerialization) input.readObject();
            System.out.println(readObject.field);
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(field);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        field = in.readUTF();
    }
}
