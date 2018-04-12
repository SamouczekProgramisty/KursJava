package pl.samouczekprogramisty.kursjava.junit5.unit;

import java.math.BigDecimal;

public class Kilogram implements WeightUnit {
    public final BigDecimal value;

    public Kilogram(BigDecimal value) {
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public Pound toPounds() {
        return new Pound(value.divide(Pound.POUND_TO_KILOGRAM_RATIO, SCALE, ROUNDING_MODE));
    }
}
