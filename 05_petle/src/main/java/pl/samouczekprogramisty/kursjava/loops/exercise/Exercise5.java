package pl.samouczekprogramisty.kursjava.loops.exercise;

public class Exercise5 {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7};
            System.out.println(sumArray(numbers));
    }

    private static int sumArray(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
