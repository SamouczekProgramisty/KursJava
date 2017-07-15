package pl.samouczekprogramisty.kursjava.methods;

public class TemperatureCheck {
    public static void main(String... args) {
        validateArguments(args);

        TemperatureCheck temperatureCheck = new TemperatureCheck();
        if (temperatureCheck.isTemperaturePositive(Double.parseDouble(args[0]))) {
            System.out.println("Wprowadzona temperatura jest dodatnia.");
        }
        else {
            System.out.println("Wprowadzona temperatura nie jest dodatnia.");
        }
    }

    private static void validateArguments(String[] args) {
        if (args.length != 1) {
            System.err.println("Prosze podaj temperature jako jedyny parametr.");
            System.exit(1);
        }
        try {
            Double.parseDouble(args[0]);
        }
        catch (NumberFormatException exception) {
            System.err.println("Podana temperatura nie jest poprawna liczbą zmienna przecinkową!");
            System.exit(2);
        }
    }

    private boolean isTemperaturePositive(double temperature) {
        return temperature > 0;
    }
}
