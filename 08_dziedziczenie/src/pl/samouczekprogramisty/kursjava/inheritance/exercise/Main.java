package pl.samouczekprogramisty.kursjava.inheritance.exercise;

public class Main {
    public static void main(String[] args) {
        Animal human = new Human();
        Animal fish = new Goldfish();

        System.out.println(human);
        System.out.println(fish);
    }
}
