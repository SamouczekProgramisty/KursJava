package pl.samouczekprogramisty.kursjava.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleNameRegexp {
    public static void main(String[] args) {
        simplePatternUsage();
    }

    private static void simplePatternUsage() {
        Pattern compiledPattern = Pattern.compile("Marcin");
        Matcher matcher = compiledPattern.matcher("Nazywam sie Marcin Pietraszek");

        System.out.println(matcher.find());
        System.out.println(matcher.matches());
    }
}
