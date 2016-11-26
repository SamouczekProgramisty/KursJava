package pl.samouczekprogramisty.regexp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexpTest {

    @Test
    public void testSymbolQuestionMark() {
        Pattern pattern = Pattern.compile("kr?at");
        assertTrue(pattern.matcher("krat").matches());
        assertTrue(pattern.matcher("kat").matches());
        assertFalse(pattern.matcher("krrat").matches());
        assertFalse(pattern.matcher("kot").matches());
    }

    @Test
    public void testSymbolAsterix() {
        Pattern pattern = Pattern.compile("uwa*ga");
        assertTrue(pattern.matcher("uwga").matches());
        assertTrue(pattern.matcher("uwaga").matches());
        assertTrue(pattern.matcher("uwaaaaaaga").matches());
        assertFalse(pattern.matcher("uwagaaaa").matches());
    }

    @Test
    public void testSymbolPlus() {
        Pattern pattern = Pattern.compile("trampo+lina");
        assertTrue(pattern.matcher("trampolina").matches());
        assertTrue(pattern.matcher("trampoooolina").matches());
        assertFalse(pattern.matcher("tramplina").matches());
    }

    @Test
    public void testSymbolDot() {
        Pattern pattern = Pattern.compile("ko.ek");
        assertTrue(pattern.matcher("kotek").matches());
        assertTrue(pattern.matcher("korek").matches());
        assertFalse(pattern.matcher("koek").matches());
        assertFalse(pattern.matcher("ktek").matches());
    }

    @Test
    public void testSymbolDotWithOthers() {
        Pattern pattern = Pattern.compile("k+a.*ta");
        assertTrue(pattern.matcher("katapulta").matches());
        assertTrue(pattern.matcher("karta").matches());
        assertTrue(pattern.matcher("kasia ma kota").matches());
        assertTrue(pattern.matcher("kkkka#$*&JHDFStatata").matches());
        assertFalse(pattern.matcher("ata").matches());
        assertFalse(pattern.matcher("kta").matches());
    }

    @Test
    public void testSimpleClasses() {
        Pattern pattern = Pattern.compile("[rtmp]aca");
        assertTrue(pattern.matcher("raca").matches());
        assertTrue(pattern.matcher("taca").matches());
        assertTrue(pattern.matcher("maca").matches());
        assertTrue(pattern.matcher("paca").matches());
        assertFalse(pattern.matcher("praca").matches());
        assertFalse(pattern.matcher("pacanow").matches());
    }

    @Test
    public void testClassWithRange() {
        Pattern pattern = Pattern.compile("[a-d]uma");
        assertTrue(pattern.matcher("auma").matches());
        assertTrue(pattern.matcher("buma").matches());
        assertTrue(pattern.matcher("cuma").matches());
        assertTrue(pattern.matcher("duma").matches());
        assertFalse(pattern.matcher("fuma").matches());
        assertFalse(pattern.matcher("abuma").matches());
    }

    @Test
    public void testClassWithRangeNumber() {
        Pattern pattern = Pattern.compile("[0-7]xyz");
        assertTrue(pattern.matcher("0xyz").matches());
        assertTrue(pattern.matcher("1xyz").matches());
        assertTrue(pattern.matcher("7xyz").matches());
        assertFalse(pattern.matcher("8xyz").matches());
        assertFalse(pattern.matcher("07xyz").matches());
    }

    @Test
    public void testClassWithMultipleRanges() {
        Pattern pattern = Pattern.compile("[a-cA-C0-3]bum");
        assertTrue(pattern.matcher("abum").matches());
        assertTrue(pattern.matcher("Bbum").matches());
        assertTrue(pattern.matcher("0bum").matches());
        assertFalse(pattern.matcher("dbum").matches());
        assertFalse(pattern.matcher("aA0bum").matches());
    }

    @Test
    public void testClassNegation() {
        Pattern pattern = Pattern.compile("[^xyz]awa");
        assertTrue(pattern.matcher("kawa").matches());
        assertTrue(pattern.matcher("pawa").matches());
        assertTrue(pattern.matcher("Wawa").matches());
        assertFalse(pattern.matcher("yawa").matches());
        assertFalse(pattern.matcher("zawa").matches());
    }

    @Test
    public void testPredefinedClases() {
        Pattern pattern = Pattern.compile("\\d\\w\\d");
        assertTrue(pattern.matcher("0_0").matches());
        assertTrue(pattern.matcher("0X1").matches());
        assertFalse(pattern.matcher("a0b").matches());
        assertFalse(pattern.matcher("0 0").matches());
    }

    @Test
    public void testBasicGroups() {
        Pattern pattern = Pattern.compile("[^-]*--(\\w+)--.*");
        Matcher matcher = pattern.matcher("Ala ma kota. Kota ma na imie --Zygmunt--. Kot jest czarny.");
        matcher.matches();
        assertEquals("Zygmunt", matcher.group(1));
    }
}
