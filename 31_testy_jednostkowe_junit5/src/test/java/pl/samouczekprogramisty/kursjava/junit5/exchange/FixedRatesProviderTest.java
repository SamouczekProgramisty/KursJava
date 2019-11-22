package pl.samouczekprogramisty.kursjava.junit5.exchange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FixedRatesProviderTest {

    private FixedRatesProvider rates;

    @BeforeEach
    void setUp() {
        rates = new FixedRatesProvider();
    }

    @Test
    void shouldReturnKnownRate() {
        rates.setRate(Currency.EUR, Currency.PLN, new BigDecimal("4.3727"));
        assertThat(rates.getRate(Currency.EUR, Currency.PLN), is(new BigDecimal("4.3727")));
    }

    @Test
    void shouldReturnReversedRate() {
        rates.setRate(Currency.EUR, Currency.PLN, new BigDecimal("4.3727"));
        assertThat(rates.getRate(Currency.PLN, Currency.EUR), is(new BigDecimal("0.2287")));
    }

    @Test
    void shouldThrowExceptionOnIllegalRatePair() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rates.getRate(Currency.PLN, Currency.EUR);
        });
        assertThat(exception.getMessage(), is("Rate for currency pair (PLN, EUR) is unknown!"));
    }

    @Test
    void shouldRoundAndScaleRate() {
        rates.setRate(Currency.EUR, Currency.PLN, new BigDecimal("4.37274"));
        assertThat(rates.getRate(Currency.EUR, Currency.PLN), is(new BigDecimal("4.3727")));
    }

}