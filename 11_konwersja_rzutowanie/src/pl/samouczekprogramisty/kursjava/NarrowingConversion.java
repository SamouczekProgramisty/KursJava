package pl.samouczekprogramisty.kursjava;

public class NarrowingConversion {
    public static void main(String[] args) {
        NarrowingConversion conversion = new NarrowingConversion();
        int intVariable = Integer.MAX_VALUE;
        long longVariable = Long.MAX_VALUE;
        long longVariableWithoutLoosingInformation = Integer.MAX_VALUE; // automatic conversion from int to long

        conversion.methodIntArgument(intVariable);
        conversion.methodIntArgument((int) longVariable);
        conversion.methodIntArgument((int) longVariableWithoutLoosingInformation);
    }

    public void methodIntArgument(int argument) {
        System.out.println(argument);
    }

    public void narrowingConversion() {
        int intValue = (int) 123.123F;
        long longValue = (long) 456.456;
        char x = 'x';
        int xx = x;

    }
}
