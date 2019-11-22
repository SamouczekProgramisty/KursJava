package pl.samouczekprogramisty.kursjava.methods;

public class TemperatureCheck {
    public static void main(String... args) {
        // this is not the best type to store temperature, stay tuned for better one ;)
        int positiveTemperature = 10;
        int negativeTemperature = -10;

        isTemperaturePositive(positiveTemperature);
        isTemperaturePositive(negativeTemperature);
    }

    private static boolean isTemperaturePositive(int temperature) {
        boolean isPositive = temperature > 0;

        if (isPositive) {
            System.out.println("Temperatura " + temperature + " jest dodatnia.");
        }
        else {
            System.out.println("Temperatura " + temperature + " nie jest dodatnia.");
        }

        return isPositive;
    }
}
