package pl.samouczekprogramisty.kursjava.junit5.unit;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitConverterTest {

    @Test
    void shouldConvertZeroKilogramValue() {
        Pound pounds = new Kilogram(BigDecimal.ZERO).toPounds();
        assertEquals(BigDecimal.ZERO.setScale(4), pounds.value);
    }

    @Test
    void shouldConvertZeroPoundValue() {
        Kilogram kilograms = new Pound(BigDecimal.ZERO).toKilograms();
        assertEquals(BigDecimal.ZERO.setScale(4), kilograms.value);
    }

    @Test
    void shouldConvert1Pound() {
        assertEquals(new BigDecimal("0.4536"), new Pound(BigDecimal.ONE).toKilograms().value);
    }

    @Test
    void shouldConvert1Kilogram() {
        assertEquals(new BigDecimal("2.2046"), new Kilogram(BigDecimal.ONE).toPounds().value);
    }

}