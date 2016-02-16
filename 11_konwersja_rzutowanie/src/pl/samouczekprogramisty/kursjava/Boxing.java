package pl.samouczekprogramisty.kursjava;

public class Boxing {
    public static void main(String[] args) {
        autounboxing();
        autoboxing();
        wideningAutoboxing();
    }

    private static void autounboxing() {
        int primitiveInt = new Integer(123);
        long primitiveLong = new Long(123L);
        float primitiveFloat = new Float(123.123F);
        double primitiveDouble = new Double(123.123);
        boolean primitiveBoolean = new Boolean(true);
    }

    private static void autoboxing() {
        Integer objectInteger = 123;
        Long objectLong = 123L;
        Float objectFloat = 123.123F;
        Double objectDouble = 123.123;
        Boolean objectBoolean = true;
    }

}
