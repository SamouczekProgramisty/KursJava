package pl.samouczekprogramisty.number;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RangeWithoutSetup {
    @Test
    public void shouldSayThat15rIsInRange() {
        Range range = new Range(10, 20);
        assertTrue(range.isInRange(15));
    }

    @Test
    public void shouldSayThat5IsntInRange() {
        Range range = new Range(10, 20);
        assertFalse(range.isInRange(5));
    }
}