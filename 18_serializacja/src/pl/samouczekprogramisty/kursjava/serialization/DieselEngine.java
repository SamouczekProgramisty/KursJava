package pl.samouczekprogramisty.kursjava.serialization;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DieselEngine extends Engine {
    public DieselEngine() {
        super("diesel");
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        throw new NotSerializableException("DieselEngine isn't serializable!");
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw new NotSerializableException("DieselEngine isn't serializable!");
    }
}
