package pl.samouczekprogramisty.kursjava.serialization;

import java.io.Serializable;

public class Engine implements Serializable {
    private static final long serialVersionUID = 1L;

    private String model;

    public Engine(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
