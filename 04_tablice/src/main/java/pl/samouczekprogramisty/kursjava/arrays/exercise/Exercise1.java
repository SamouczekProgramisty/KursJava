package pl.samouczekprogramisty.kursjava.arrays.exercise;


public class Exercise1 {
    public int sum(int[] numbers) {
        return numbers[0] + numbers[1];
    }

    public static void main(String[] args) {
        Exercise1 exercise = new Exercise1();
        int[] numbers = {3, 4};
        System.out.println(exercise.sum(numbers));
    }
}
