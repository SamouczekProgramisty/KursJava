package pl.samouczekprogramisty.kursjava.interfaces;

public class Male implements Human {
    private int age;
    private double weight;
    private double height;
    private String name;
    private boolean isMale;

    public Male(int age, double weight, double height, String name) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.name = name;
        isMale = true;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }
}
