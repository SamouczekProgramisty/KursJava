package pl.samouczekprogramisty.kursjava.exception;

public class ExceptionInheritance {
    public static void main(String[] args) {
        multipleCatchBlocks();
        multipleExceptionsInOneCatch();
    }

    private static void multipleExceptionsInOneCatch() {
        try {
            someMagicMethod();
        }
        catch (ArithmeticException | IllegalArgumentException exception) {
            // handle exception
        }
    }

    private static void someMagicMethod() {
    }

    private static void multipleCatchBlocks() {
        try {
            throw new IllegalArgumentException();
        }
        catch (ArithmeticException exception) {
            // 1
        }
        catch (RuntimeException exception) {
            // 2
        }
        catch (Exception exception) {
            // 3
        }
    }
}
