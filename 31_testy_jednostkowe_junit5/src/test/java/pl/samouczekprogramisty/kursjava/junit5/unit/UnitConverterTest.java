package pl.samouczekprogramisty.kursjava.junit5.unit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class UnitConverterTest {

    @Test
    @Disabled
    void shouldConvertZeroKilogramValue() {
        Pound pounds = new Kilogram(BigDecimal.ZERO).toPounds();
        assertEquals(BigDecimal.ZERO.setScale(44), pounds.value);
    }

    @Test
    @ExtendWith(SamouczekExtension.class)
    void shouldConvertZeroPoundValue() {
        Kilogram kilograms = new Pound(BigDecimal.ZERO).toKilograms();
        assertEquals(BigDecimal.ZERO.setScale(4), kilograms.value);
    }

    @Test
    @SamouczekBefore
    void shouldConvert1Pound() {
        assertEquals(new BigDecimal("0.4536"), new Pound(BigDecimal.ONE).toKilograms().value);
    }

    @Test
    void shouldConvert1Kilogram() {
        assertEquals(new BigDecimal("2.2046"), new Kilogram(BigDecimal.ONE).toPounds().value);
    }

    @Test
    @DisplayName("0.1 pounds to kilograms ♥ ♦ ♣ ♠")
    void shouldConvertFractions() {
        assertEquals(new BigDecimal("0.0454"), new Pound(new BigDecimal("0.1")).toKilograms().value);
    }

    @Nested
    class ExceptionHandling {
        @Test
        void shouldntAcceptNegativeWeightInPounds() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Pound(new BigDecimal(-1)));
            assertEquals("Weight can't be negative!", exception.getMessage());
        }

        @Test
        void shouldntAcceptNegativeWeightInKilograms() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Kilogram(new BigDecimal(-1)));
            assertEquals("Weight can't be negative!", exception.getMessage());
        }

        @Test
        void shouldntAcceptNullValue() {
            assertAll(
                () -> assertThrows(NullPointerException.class, ()-> new Kilogram(null)),
                () -> assertThrows(NullPointerException.class, ()-> new Pound(null))
            );
        }
    }

    @Nested
    class TimeLimitations {
        @Test
        void shouldTransalteUnitsBlazinglyFast() {
            assertTimeout(Duration.ofMillis(10), () -> new Kilogram(BigDecimal.TEN).toPounds());
        }
    }

    @RepeatedTest(3)
    void shouldAlwaysReturnTheSameValue() {
        assertEquals(new BigDecimal("29.4840").setScale(4), new Pound(new BigDecimal(65)).toKilograms().value);
    }
}