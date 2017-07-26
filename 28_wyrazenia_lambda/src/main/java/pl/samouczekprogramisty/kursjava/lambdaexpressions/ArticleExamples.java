package pl.samouczekprogramisty.kursjava.lambdaexpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class ArticleExamples {

    public ArticleExamples(int x, long y, boolean z) {
    }

    public static void main(String[] args) {
        sampleAnonymousClass();
        sampleLambdaExpressions();
        sampleMethodReferenceExpressions();

        sampleUsage();
    }

    private static void sampleUsage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Consumer<Integer> integerConsumer = n -> System.out.println(n);
        numbers.forEach(integerConsumer);

        numbers.forEach(System.out::println);

        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    private static void sampleAnonymousClass() {
        Checker<Integer> isOddAnonymous = new Checker<Integer>() {
            @Override
            public boolean check(Integer object) {
                return object % 2 != 0;
            }
        };

        Checker<Integer> isOddLambda = object -> object % 2 != 0;

        System.out.println(isOddAnonymous.check(123));
        System.out.println(isOddAnonymous.check(124));

        System.out.println(isOddLambda.check(123));
        System.out.println(isOddLambda.check(124));

        Function<Integer, Boolean> isOddLambda2 = object -> object % 2 != 0;

        System.out.println(isOddLambda2.apply(123));
        System.out.println(isOddLambda2.apply(124));
    }

    private static void sampleLambdaExpressions() {
        UnaryOperator<Integer> square = x -> x * x;
        Supplier<String> someString = () -> "some return value";
        BiConsumer<Integer, Long> multiplier = (Integer x, Long y) -> System.out.println(x * y);
        Function<Integer, Long> multiline = x -> {
            if (x != null && x % 2 == 0) {
                return (long) x * x;
            }
            else {
                return 123L;
            }
        };
        SideEffectMethod sideEffectMethod = () -> {};
    }

    private static void sampleMethodReferenceExpressions() {
        constructorReference();
        methodReference();
        instanceMethodReference();
        arrayConstructorReference();
    }

    private static void constructorReference() {
        Supplier<Object> objectCreator = Object::new;
        System.out.println(objectCreator.get());

        // exactly the same as above, without method reference expression
        System.out.println(new Object());
    }

    private static void methodReference() {
        ToIntFunction<Object> equalsMethodOnClass = Object::hashCode;
        Object objectInstance = new Object();
        System.out.println(equalsMethodOnClass.applyAsInt(objectInstance));

        // exactly the same as above, without method reference expression
        System.out.println(objectInstance.hashCode());
    }

    private static void instanceMethodReference() {
        Object objectInstance = new Object();
        IntSupplier equalsMethodOnObject = objectInstance::hashCode;
        System.out.println(equalsMethodOnObject.getAsInt());

        // exactly the same as above, without method reference expression
        System.out.println(objectInstance.hashCode());
    }

    private static void arrayConstructorReference() {
        Function<Integer, int[]> arrayCreator = int[]::new;
        // same as new int[10]
        int[] array = arrayCreator.apply(10);
    }

}