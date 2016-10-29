package pl.samouczekprogramisty.number;

public class Range {
    private final long lowerBound;
    private final long upperBound;

    public Range(long lowerBound, long upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("lowerBound is bigger than upperBound!");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean isInRange(long number) {
        return number >= lowerBound && number <= upperBound;
    }
}
