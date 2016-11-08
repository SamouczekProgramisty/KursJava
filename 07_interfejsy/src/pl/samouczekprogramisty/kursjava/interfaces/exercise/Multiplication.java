package pl.samouczekprogramisty.kursjava.interfaces.exercise;

public class Multiplication implements Computation {
    @Override
    public double compute(double arg1, double arg2) {
        return arg1 * arg2;
    }
}
