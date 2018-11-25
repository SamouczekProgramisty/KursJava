package pl.samouczekprogramisty.kursjava.arrays.exercise;

public class Exercise2 {
    public int biggest(int[] numbers) {
        int biggest = numbers[0];
        if (numbers[1] > biggest) {
            biggest = numbers[1];
        }
        if (numbers[2] > biggest) {
            biggest = numbers[2];
        }
        return biggest;
    }

    public int biggestWithoutIf(int[] numbers) {
        return Math.max(numbers[0], Math.max(numbers[1], numbers[2]));
    }

    public static void main(String[] args) {
        Exercise2 exercise = new Exercise2();
        int[] numbers = new int[]{1, 3, -5};
        System.out.println(exercise.biggest(numbers));
        System.out.println(exercise.biggestWithoutIf(numbers));
    }
}
