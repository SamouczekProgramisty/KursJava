package pl.samouczekprogramisty.kursjava.objects;

public class MyNumber {
    private double value;

    public MyNumber(double value) {
        this.value = value;
    }

    public boolean isOdd() {
        return ! isEven();
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public double sqrt() {
        return Math.sqrt(value);
    }

    public MyNumber pow(MyNumber pow) {
        return new MyNumber(Math.pow(value, pow.value));
    }

    public MyNumber add(MyNumber otherValue) {
        return new MyNumber(value + otherValue.value);
    }

    public MyNumber subract(MyNumber otherValue) {
        return new MyNumber(value - otherValue.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
