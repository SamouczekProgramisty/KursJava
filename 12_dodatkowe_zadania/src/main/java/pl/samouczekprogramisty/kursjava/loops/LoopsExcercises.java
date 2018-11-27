package pl.samouczekprogramisty.kursjava.loops;


public class LoopsExcercises {
    public static void main(String[] args) {
        printFrom0ToN(5);
        printFrom0ToNWithWhileLoop(5);
        printCharPerLine(1234);
        System.out.println(reverse("pies"));
        printBinary(7);
        System.out.println(isPalindrome("kajak"));
        printArray(new int[]{1, 2, 3});
        int[] inputArray = new int[]{4, 5, 1, 3, 2};
        bubbleSort(inputArray);
        printArray(inputArray);
    }

    private static String reverse(String word) {
        char[] chars = word.toCharArray();
        for (int currentCharIndex = 0; currentCharIndex < chars.length / 2; currentCharIndex++) {
            char tempChar = chars[currentCharIndex];
            int curretnCharFromEndIndex = chars.length - currentCharIndex - 1;

            chars[currentCharIndex] = chars[curretnCharFromEndIndex];
            chars[curretnCharFromEndIndex] = tempChar;
        }
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            result += chars[i];
        }
        return result;
    }

    private static void printFrom0ToN(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(i);
        }
    }

    private static void printFrom0ToNWithWhileLoop(int n) {
        int index = 0;
        while (index <= n) {
            System.out.println(index++);
        }
    }

    private static void printCharPerLine(int number) {
        while (number > 0) {
            int reminder = number % 10;
            number /= 10;
            System.out.println(reminder);
        }
    }

    public static void printBinary(int number) {
        String binaryReversed = "";
        while (number > 0) {
            // This is isn't optimal ;)
            // Read about StringBuilder/StringBuffer
            binaryReversed += number % 2;
            number /= 2;
        }
        System.out.println(reverse(binaryReversed));
    }

    private static boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char currentLetter = chars[i];
            char correspondantLetterFromEnd = chars[chars.length - i - 1];
            if (! (currentLetter == correspondantLetterFromEnd)) {
                return false;
            }
        }
        return true;
        //return word.equals(reverse(word));
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            boolean isLastOne = i == array.length - 1;
            if (isLastOne) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i]);
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int current = 0; current < array.length - 1 - i; current++) {
                int next = current + 1;
                if (array[current] > array[next]) {
                    int tmp = array[next];
                    array[next] = array[current];
                    array[current] = tmp;
                }
            }
        }
    }
}