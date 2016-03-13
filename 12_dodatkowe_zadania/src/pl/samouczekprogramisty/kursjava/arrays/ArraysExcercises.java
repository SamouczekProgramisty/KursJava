package pl.samouczekprogramisty.kursjava.arrays;

public class ArraysExcercises {
    public static void main(String[] args) {
        get5AlphabetLetters();
        revertArray(new double[] {1, 2, 3});
    }

    private static String[] get5AlphabetLetters() {
        return new String[] {"a", "ą", "b", "c", "ć"};
    }

    private static double[] revertArray(double[] array) {
        return new double[] {array[2], array[1], array[0]};
    }

}
