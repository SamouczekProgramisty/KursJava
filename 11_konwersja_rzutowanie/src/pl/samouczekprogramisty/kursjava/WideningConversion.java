package pl.samouczekprogramisty.kursjava;

public class WideningConversion {
    public static void main(String[] args) {
        WideningConversion conversion = new WideningConversion();
        int intVariable = Integer.MAX_VALUE;
        long longVariable = Long.MAX_VALUE;

        conversion.methodLongArgument(intVariable);
        conversion.methodLongArgument(longVariable);
    }

    public void methodLongArgument(long argument) {
        System.out.println(argument);
    }
}
