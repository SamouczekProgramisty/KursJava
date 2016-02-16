package pl.samouczekprogramisty.kursjava;

public class ArithmeticConversion {
    public static void main(String[] args) {
        short shortValue = 1;
        int intValue = 1;
        long longValue = 2;
        float floatValue = 3.1F;
        double doubleValue = 4.1;

        System.out.println(intValue + doubleValue);
        System.out.println(intValue + floatValue);
        System.out.println(intValue + longValue);
        System.out.println(shortValue + shortValue);

        System.out.println(1 / 0.5);
        System.out.println(5/2.);
    }
}
