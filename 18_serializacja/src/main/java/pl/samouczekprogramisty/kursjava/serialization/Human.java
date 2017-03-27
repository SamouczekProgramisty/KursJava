package pl.samouczekprogramisty.kursjava.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient Integer age;
    private String name;

    public Human(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human human = new Human("Krzysiek", 21);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("human.bin"))) {
            output.writeObject(human);
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("human.bin"))) {
            Human readHuman = (Human) input.readObject();
            System.out.println(readHuman.getName());
            System.out.println(readHuman.getAge());
        }
    }
}
