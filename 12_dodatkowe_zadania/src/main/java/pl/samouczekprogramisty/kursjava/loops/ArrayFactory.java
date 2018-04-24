package pl.samouczekprogramisty.kursjava.loops;

public class ArrayFactory {

    private final int size;

    public ArrayFactory(int size) {
        this.size = size;
    }

    public int[] buildOneDimension() {
        return new int[size];
    }

    public int[][] buildTwoDimensions() {
        int[][] array = new int[size][];
        for(int i = 0; i < size; i++) {
            array[i] = new int[size];
        }
        return array;
    }

    public int[][] buildTwoDimensionsInOneLine() {
        return new int[size][size];
    }

    public int[][] identityMatrix() {
        int[][] matrix = buildTwoDimensions();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
                else {
                    // that line is superfluous, arrays are initialized with default value, 0 in case of int type
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
