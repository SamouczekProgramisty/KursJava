package pl.samouczekprogramisty.kursjava.strings;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class StringCacheTest {

    @Test
    public void twoLiterals() {
        String someVariable = "samouczek programisty";
        String otherVariable = "samouczek programisty";

        assertEquals(someVariable, otherVariable);
        assertSame(someVariable, otherVariable);
    }

    @Test
    public void twoNewObjects() {
        String someVariable = new String("samouczek programisty");
        String otherVariable = new String("samouczek programisty");

        assertEquals(someVariable, otherVariable);
        assertNotSame(someVariable, otherVariable);
    }

    @Test
    public void literalAndInternedObject() {
        String someVariable = "samouczek programisty";
        String otherVariable = new String("samouczek programisty").intern();

        assertEquals(someVariable, otherVariable);
        assertSame(someVariable, otherVariable);
    }
}
