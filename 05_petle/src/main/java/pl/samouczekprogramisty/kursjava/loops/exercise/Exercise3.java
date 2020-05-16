package pl.samouczekprogramisty.kursjava.loops.exercise;

public class Exercise3 {
    public static void main(String[] args) {
        for(int number = -10; number <= 40; number++) {
            if (number % 2 != 0) {
                System.out.println(number);
            }
        }
    }
}
