package pl.samouczekprogramisty.kursjava.loops.exercise;

public class Exercise6 {

    public static void main(String[] args) {
        int[][] numbers = new int[][] {new int[] {1, 2}, new int[] {3, 4}, new int[] {5, 6, 7}};
        System.out.println(sumArray(numbers));
    }

    private static int sumArray(int[][] numbers) {
        int sum = 0;
        for (int[] otherNumbers : numbers) {
            for (int number : otherNumbers) {
                sum += number;
            }
        }
        return sum;
    }

}
