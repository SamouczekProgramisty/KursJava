package pl.samouczekprogramisty.kursjava;

public class AssignmentConversion {
    public static void main(String[] args) {
        long longValue = 123;
        int intValue = (short) 123;
        float floatValue = 12.12F;
        double doubleValue = floatValue;

        System.out.println(longValue);
        System.out.println(intValue);
        System.out.println(floatValue);
        System.out.println(doubleValue);
    }

    private static void stringConversion() {
        String x = "123" + new Object();
        String y = new Object() + "123";
        String z = 1 + "123";
    }
}
