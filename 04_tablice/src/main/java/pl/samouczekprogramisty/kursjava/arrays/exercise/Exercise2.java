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

    public int biggestWithoutIf(int [] numbers) {
        return Math.max(numbers[0], Math.max(numbers[1], numbers[2]));
    }
}
