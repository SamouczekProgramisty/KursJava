package pl.samouczekprogramisty.kursjava.genericinteritance;

public class Main {
    public static void main(String[] args) {
        FancyBox<String> box = new FancyBox<>("something");
        box.saySomethingFancy();
    }
}
