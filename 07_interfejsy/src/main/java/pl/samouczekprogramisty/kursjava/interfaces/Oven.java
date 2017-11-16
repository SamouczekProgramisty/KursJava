package pl.samouczekprogramisty.kursjava.interfaces;

public class Oven implements BakingOven, RoastingOven {

    private int time;
    private int temperature;

    @Override
    public void bakeBread() {
        temperature = 200;
        time = 120;
        turnOn();
    }

    @Override
    public void bakeCookies() {
        temperature = 180;
        time = 90;
        turnOn();
    }

    @Override
    public void roastChicken() {
        temperature = 130;
        time = 240;
        turnOn();
    }

    private void turnOn() {
        System.out.println(String.format("Start. Heat up to %s and work for %d minutes.", temperature, time));
    }

    public static void main(String[] args) {
        Oven oven = new Oven();
        BakingOven bakingOven = oven;
        RoastingOven roastingOven = oven;

        bakingOven.bakeBread();
        bakingOven.bakeCookies();
        roastingOven.roastChicken();
    }
}
