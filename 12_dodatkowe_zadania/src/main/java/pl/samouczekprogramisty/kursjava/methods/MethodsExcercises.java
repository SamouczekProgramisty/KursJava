package pl.samouczekprogramisty.kursjava.methods;


public class MethodsExcercises {
    public static void main(String[] args) {
        System.out.println(getMyAge());
        System.out.println(getMyName());
        printMatEquationResults(5, 7);
        System.out.println(isEven(8));
        System.out.println(couldDivideBy3and5(15));
        System.out.println(thirdPow(4));
        System.out.println(sqrt(4));
        System.out.println(canConstructRightAngledTriangle(3, 4, 5));
    }

    private static int getMyAge() {
        return 30;
    }

    private static String getMyName() {
        return "Marcin";
    }

    private static void printMatEquationResults(double arg1, double arg2) {
        System.out.println(arg1 + arg2);
        System.out.println(arg1 - arg2);
        System.out.println(arg1 * arg2);
    }

    private static boolean isEven(double number) {
        return number % 2 == 0;
    }

    private static boolean couldDivideBy3and5(double number) {
        return number % 3 == 0 && number % 5 == 0;
    }

    private static double thirdPow(double number) {
        return Math.pow(number, 3);
    }

    private static double sqrt(double number) {
        return Math.sqrt(number);
    }

    private static boolean canConstructRightAngledTriangle(double number1, double number2, double number3) {
        if (number1 < 0 || number2 < 0 || number3 < 0) {
            return false;
        }
        // double[] sides = new double[] {number1, number2, number3};
        // Arrays.sort(sides);
        // return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];

        double longest = number1;
        double side1 = number2;
        double side2 = number3;

        if (number2 > number1 && number2 > number3) {
            longest = number2;
            side1 = number1;
            side2 = number3;
        }
        else if (number3 > number1 && number3 > number2) {
            longest = number3;
            side1 = number1;
            side2 = number2;
        }

        return side1 * side1 + side2 * side2 == longest * longest;
    }
}
