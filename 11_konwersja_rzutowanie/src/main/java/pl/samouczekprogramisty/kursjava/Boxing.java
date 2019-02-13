package pl.samouczekprogramisty.kursjava;

public class Boxing {
    public static void main(String[] args) {
        autounboxing();
        autoboxing();
    }

    private static void autounboxing() {
        int primitiveInt = Integer.valueOf(123);
        long primitiveLong = Long.valueOf(123L);
        float primitiveFloat = Float.valueOf(123.123F);
        double primitiveDouble = Double.valueOf(123.123);
        boolean primitiveBoolean = Boolean.valueOf(true);
    }

    private static void autoboxing() {
        Integer objectInteger = 123;
        Long objectLong = 123L;
        Float objectFloat = 123.123F;
        Double objectDouble = 123.123;
        Boolean objectBoolean = true;
    }

}
