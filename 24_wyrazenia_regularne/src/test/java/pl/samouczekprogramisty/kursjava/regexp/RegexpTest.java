package pl.samouczekprogramisty.kursjava.regexp;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexpTest {
    @Test
    public void shouldBeGreedy() {
        Pattern pattern = Pattern.compile("<(.+)>");
        Matcher matcher = pattern.matcher("<em>some emphasized text</em>");
        assertTrue(matcher.find());
        assertEquals("em>some emphasized text</em", matcher.group(1));
    }

    @Test
    public void shouldBeAbleToCheatGreadiness() {
        Pattern pattern = Pattern.compile("<([^>]+)>");
        Matcher matcher = pattern.matcher("<em>some emphasized text</em>");
        assertTrue(matcher.find());
        assertEquals("em", matcher.group(1));
    }

    @Test
    public void shouldTurnOffGreedinessForPlus() {
        Pattern pattern = Pattern.compile("<(.+?)>");
        Matcher matcher = pattern.matcher("<em>some emphasized text</em>");
        assertTrue(matcher.find());
        assertEquals("em", matcher.group(1));
    }

    @Test
    public void shouldTurnOffGreedinessForAsterix() {
        Pattern pattern = Pattern.compile("<(.*?)>");
        Matcher matcher = pattern.matcher("<em>some emphasized text</em>");
        assertTrue(matcher.find());
        assertEquals("em", matcher.group(1));
    }

    @Test
    public void shouldTurnOffGreadinessForCurlyBraces() {
        Pattern pattern = Pattern.compile("(.{3,5}?)");
        Matcher matcher = pattern.matcher("12345");
        assertTrue(matcher.find());
        assertEquals("123", matcher.group(1));
    }

    @Test
    public void shouldParseAlternative() {
        Pattern pattern = Pattern.compile("skręć w (prawo|lewo)");
        Matcher matcher = pattern.matcher("skręć w lewo");
        assertTrue(matcher.find());
        assertEquals("lewo", matcher.group(1));


        matcher = pattern.matcher("skręć w prawo");
        assertTrue(matcher.find());
        assertEquals("prawo", matcher.group(1));
    }

    @Test
    public void shouldPickOneFromMultipleAlternatives() {
        Pattern pattern = Pattern.compile("pies|kot|lew");
        Matcher matcher = pattern.matcher("lew");
        assertTrue(matcher.matches());
        assertEquals("lew", matcher.group());
    }

    @Test
    public void shouldUseNonCapturingGroups() {
        Pattern pattern = Pattern.compile("(?:Ala|Ola) ma (kota|psa)");
        Matcher matcher = pattern.matcher("Ola ma psa");
        assertTrue(matcher.matches());
        assertEquals("psa", matcher.group(1));
    }

    @Test
    public void shouldUseNamedGroups() {
        Pattern pattern = Pattern.compile("(?<day>\\d{2})\\.(?<month>\\d{2})\\.(?<year>\\d{4})");
        Matcher matcher = pattern.matcher("04.01.2017");
        assertTrue(matcher.matches());
        assertEquals("04", matcher.group("day"));
        assertEquals("04", matcher.group(1));
        assertEquals("2017", matcher.group("year"));
        assertEquals("2017", matcher.group(3));
    }

    @Test
    public void shouldReuseGroupsInsideRegexp() {
        Pattern pattern = Pattern.compile("<(.+?)>(.+?)</\\1>");
        Matcher matcher = pattern.matcher("<p>Some paragraph <em>emphasized</em></p><p>Other paragraph</p>");
        assertTrue(matcher.find());
        assertEquals("p", matcher.group(1));
        assertEquals("Akapit tekstu <em>coś innego</em>", matcher.group(2));
    }

    @Test
    public void shouldShowDifferenceBetweenFindAndMatches() {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("abc123def");
        assertTrue(matcher.find());
        assertFalse(matcher.matches());
    }

    @Test
    public void shouldShowDifferenceBetweenFindAndMatchesWithAncors() {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher("abc123def");
        assertFalse(matcher.find());
        assertFalse(matcher.matches());
    }
}
