package pl.samouczekprogramisty.kursjava.serialization;

import java.io.Serializable;

public class Tyre implements Serializable {
    private static final long serialVersionUID = 1L;

    private int size;
    private boolean isFlat;

    public Tyre(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public boolean isFlat() {
        return isFlat;
    }
}
