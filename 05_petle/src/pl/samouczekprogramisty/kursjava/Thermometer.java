package pl.samouczekprogramisty.kursjava;

/**
 * Created by mapi on 14.11.15.
 */
public class Thermometer {
    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();
        //thermometer.ifExample();
//        thermometer.switchExample();
//        thermometer.forExample();
        thermometer.whileExample();
    }

    private void whileExample() {
        int number = 0;
        while (number < 10) {
            System.out.println(number);
            number++;
        }

        number = 0;
        while (true) {
            System.out.println(number);
            number++;
            if (number == 10) {
                break;
            }
        }
    }

    private void forExample() {
        for (int number = 1; number <= 10; number = number + 1) {
            System.out.println(number);
        }
        int[] primeNumbers = new int[] {2, 3, 5, 7};

        for (int index = 0; index < primeNumbers.length; index++) {
            System.out.println(primeNumbers[index]);
        }

        for (int primeNumber : primeNumbers) {
            System.out.println(primeNumber);
        }
    }

    private void switchExample() {
        int temperature = 36;
        switch (temperature) {
            default:
                System.out.println("Nie wiem jak się czujesz :(");
            case 35:
                System.out.println("Jesteś osłabiony?");
                break;
            case 36:
                System.out.println("Wszystko w normie!");
                break;
            case 37:
                System.out.println("Jesteś przeziębiony?");
                break;
            case 38:
                System.out.println("Chyba jesteś chory.");
                break;

        }
    }

    private void ifExample() {
        int temperature = 38;
        if (temperature < 36) {
            System.out.println("Jesteś osłabiony?");
        }
        else if (temperature < 37) {
            System.out.println("Wszystko w normie!");
        }
        else if (temperature < 38) {
            System.out.println("Jesteś przeziębiony?");
        }
        else {
            System.out.println("Masz co najmniej 38 stopni! Biegiem do lekarza!");
        }
    }
}
