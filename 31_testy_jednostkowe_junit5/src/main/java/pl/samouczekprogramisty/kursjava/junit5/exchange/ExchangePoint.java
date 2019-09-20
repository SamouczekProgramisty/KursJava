package pl.samouczekprogramisty.kursjava.junit5.exchange;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangePoint {

    private static final int SCALE = 4;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    private final RatesProvider ratesProvider;
    private final BigDecimal askSpread;
    private final BigDecimal bidSpread;

    public ExchangePoint(BigDecimal spread, RatesProvider ratesProvider) {
        if (spread.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(String.format("Spread %s is illegal! Spread must be positive!", spread));
        }
        if (spread.compareTo(BigDecimal.ONE) >= 0) {
            throw new IllegalArgumentException(String.format("Spread %s is illegal! Spread must be smaller than 1!", spread));
        }
        this.askSpread = BigDecimal.ONE.add(spread).setScale(SCALE, ROUNDING_MODE);
        this.bidSpread = BigDecimal.ONE.subtract(spread).setScale(SCALE, ROUNDING_MODE);
        this.ratesProvider = ratesProvider;
    }

    public BigDecimal getBidPrice(BigDecimal amount, Currency from, Currency to) {
        return getExchangePrice(amount, from, to, bidSpread);
    }

    public BigDecimal getAskPrice(BigDecimal amount, Currency from, Currency to) {
        return getExchangePrice(amount, from, to, askSpread);
    }

    private BigDecimal getExchangePrice(BigDecimal amount, Currency from, Currency to, BigDecimal spread) {
        BigDecimal rate = ratesProvider.getRate(from, to);
        BigDecimal amountInDesiredCurrency = amount.multiply(rate);
        return amountInDesiredCurrency.multiply(spread);
    }

}
