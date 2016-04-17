package pl.samouczekprogramisty.kursjava;

public class ComparisionExamples {

    public static void main(String[] args) {
        rawTypesComparison();
        rawFloatingPointComparison();
        objectsComparison();
        customObjectsComparison();
    }

    private static void customObjectsComparison() {
        Chair chair1 = new Chair("Adde", "IKEA", 2016);
        Chair chair2 = new Chair("Janinge", "IKEA", 2016);
        Chair chair3 = new Chair("Adde", "IKEA", 2015);
        Chair chair4 = new Chair("Adde", "IKEA", 2016);

        System.out.println("chair1.equals(chair2): " + chair1.equals(chair2));
        System.out.println("chair1.equals(chair3): " + chair1.equals(chair3));
        System.out.println("chair1.equals(chair4): " + chair1.equals(chair4));
        System.out.println("chair1.equals(null): " + chair1.equals(null));
    }

    private static void objectsComparison() {
        System.out.println("test == test: " + (new String("test") == new String("test")));
        System.out.println("test equals test: " + new String("test").equals(new String("test")));

        String reference1 = new String("something");
        String reference2 = reference1;
        System.out.println("reference1 == reference2: " + (reference1 == reference2));
    }

    private static void rawFloatingPointComparison() {
        System.out.println("10.123 == 10.123: " + (10.123 == 10.123)); // !!!
        System.out.println("10.123 == 10.123: " + (Math.abs(10.123 - 10.123) < 0.000001));
    }

    private static void rawTypesComparison() {
        System.out.println("10 == 10: " + (10 == 10));
        System.out.println("10 != 10: " + (10 != 10));
        System.out.println("true == true: " + (true == true));
        System.out.println("true != true: " + (true != true));
        System.out.println("'a' == 'a': " + ('a' == 'a'));
        System.out.println("'a' != 'a': " + ('a' != 'a'));
        System.out.println("500L == 500L: " + (500L == 500L));
        System.out.println("500L != 500L: " + (500L != 500L));
    }
}
