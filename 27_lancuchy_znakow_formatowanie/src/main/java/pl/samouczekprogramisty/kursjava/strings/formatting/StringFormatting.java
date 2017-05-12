package pl.samouczekprogramisty.kursjava.strings.formatting;

import java.util.Formatter;
import java.util.Locale;

public class StringFormatting {

    public static void main(String[] args) {
        simpleFormatterExample();
        simplifiedFormatterExample();
        indexArgument();
        widthArgument();
        precisionArgument();
        localeExamples();
    }

    private static void localeExamples() {
        double someNumber = 12345.12;
        System.out.format(Locale.US, "%,.2f%n", someNumber);
        System.out.format(Locale.GERMAN, "%,.2f%n", someNumber);
        System.out.format(Locale.forLanguageTag("PL"), "%,.2f%n", someNumber);
    }

    private static void simpleFormatterExample() {
        Formatter formatter = new Formatter();
        formatter.format("Samouczek Programisty istnieje od %d roku. Wszystkie artykuły pisze %s.", 2015, "Marcin");
        String formattedString = formatter.toString();
        System.out.println(formattedString);
    }

    private static void simplifiedFormatterExample() {
        System.out.format("Samouczek Programisty istnieje od %d roku. Wszystkie artykuły pisze %s.%n", 2015, "Marcin");
    }

    private static void complicatedExample() {
        System.out.format("%2$08.3f %3$(,08.3f %s", 123, -1.234567, -2.123456, 123);
        System.out.println();
    }

    private static void indexArgument() {
        System.out.format("%2$s %1$s %1$s%n", "[pierwszy argument]", "[drugi argument]");
    }

    private static void widthArgument() {
        System.out.format("[%10s] [%3s]%n", "test", "test");
    }

    private static void precisionArgument() {
        double x = 1.1234567890123;
        System.out.format("[%.10f] [%.3f] [%f]%n", x, x, x);
    }
}
