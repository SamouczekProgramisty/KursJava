package pl.samouczekprogramisty.kursjava.exception;

public class BasicExceptions {
    public int getNumberOfSeconds(int hour) {
        if (hour < 0) {
            throw new IllegalArgumentException("Hour must be >= 0: " + hour);
        }
        return hour * 60 * 60;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(-1));
        BasicExceptions instance = new BasicExceptions();
        int argument = -3;
        int numberOfSeconds = 0;
        try {
            numberOfSeconds = instance.getNumberOfSeconds(argument);
        }
        catch (IllegalArgumentException e) {
            numberOfSeconds = instance.getNumberOfSeconds(argument * -1);
        }
        System.out.println(numberOfSeconds);
    }
}
