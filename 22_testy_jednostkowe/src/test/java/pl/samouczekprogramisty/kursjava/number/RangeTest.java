package pl.samouczekprogramisty.kursjava.number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RangeTest {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(10, 20);
    }

    @Test
    public void shouldSayThat15rIsInRange() {
        assertTrue(range.isInRange(15));
    }

    @Test
    public void shouldSayThat5IsntInRange() {
        assertFalse(range.isInRange(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionOnWrongParameters() {
        new Range(20, 10);
    }

    @Test
    public void shouldHaveProperErrorMessage() {
        try {
            new Range(20, 10);
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("lowerBound is bigger than upperBound!", exception.getMessage());
        }
    }
}