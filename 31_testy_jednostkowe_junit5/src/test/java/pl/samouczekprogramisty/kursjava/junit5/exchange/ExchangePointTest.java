package pl.samouczekprogramisty.kursjava.junit5.exchange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangePointTest {
    @Mock
    RatesProvider ratesProvider;

    @Test
    void shouldntAcceptNegativeSpread() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new ExchangePoint(BigDecimal.valueOf(-1), ratesProvider);
        });
        assertThat(thrown.getMessage(), is ("Spread -1 is illegal! Spread must be positive!"));
    }

    @Test
    void shouldntAcceptSpreadEqualTo1() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new ExchangePoint(BigDecimal.ONE, ratesProvider);
        });
        assertThat(thrown.getMessage(), is("Spread 1 is illegal! Spread must be smaller than 1!"));
    }

    @Test
    void shouldntAcceptSpreadBiggerThan1() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new ExchangePoint(BigDecimal.TEN, ratesProvider);
        });
        assertThat(thrown.getMessage(), is("Spread 10 is illegal! Spread must be smaller than 1!"));
    }

    @Test
    void shouldReturnBidPriceForCurrencyAfterSpread() {
        when(ratesProvider.getRate(any(Currency.class), any(Currency.class))).thenReturn(BigDecimal.ONE);
        ExchangePoint exchangePoint = new ExchangePoint(new BigDecimal("0.05"), ratesProvider);

        assertThat(exchangePoint.getBidPrice(BigDecimal.TEN, Currency.EUR, Currency.PLN), is(new BigDecimal("9.5000")));
    }

    @Test
    void shouldReturnAskPriceForCurrencyAfterSpread() {
        when(ratesProvider.getRate(any(Currency.class), any(Currency.class))).thenReturn(BigDecimal.ONE);
        ExchangePoint exchangePoint = new ExchangePoint(new BigDecimal("0.05"), ratesProvider);

        assertThat(exchangePoint.getAskPrice(BigDecimal.TEN, Currency.EUR, Currency.PLN), is(new BigDecimal("10.5000")));
    }
}