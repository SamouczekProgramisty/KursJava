package pl.samouczekprogramisty.regexp.exercise;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExerciseTest {
    @Test
    public void shouldValidateFloatingpointNumber() {
        Pattern pattern = Pattern.compile("-?\\d+(,\\d+)?");
        assertTrue(pattern.matcher("123,2341515132135").matches());
        assertTrue(pattern.matcher("-10").matches());
        assertFalse(pattern.matcher("18-12").matches());
        assertFalse(pattern.matcher("123,").matches());
    }

    @Test
    public void shouldValidateHouseNumber() {
        Pattern pattern = Pattern.compile("\\d+[A-Z]?\\\\\\d+[A-Z]?");
        assertTrue(pattern.matcher("123\\2A").matches());
        assertTrue(pattern.matcher("24B\\3").matches());
        assertTrue(pattern.matcher("12\\5").matches());
        assertFalse(pattern.matcher("abc\\cba").matches());
        assertFalse(pattern.matcher("12").matches());
    }

    @Test
    public void shouldValidateCityName() {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+([ -][A-Z][a-z]+)?");
        assertTrue(pattern.matcher("Wroclaw").matches());
        assertTrue(pattern.matcher("Zielona Gora").matches());
        assertTrue(pattern.matcher("Bielsko-Biala").matches());
        assertFalse(pattern.matcher("Ptysiow123").matches());
        assertFalse(pattern.matcher("wroclaw").matches());
    }
}
