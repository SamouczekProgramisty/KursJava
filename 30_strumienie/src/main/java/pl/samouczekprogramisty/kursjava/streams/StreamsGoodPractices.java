package pl.samouczekprogramisty.kursjava.streams;

import java.util.stream.IntStream;

public class StreamsGoodPractices {
    public static void main(String[] args) {
        readabilityMatters();
        orderMatters();
    }

    private static void readabilityMatters() {
        IntStream.range(1950, 2150)
            .filter(StreamsGoodPractices::isLeapYear)
            .forEach(System.out::println);

        System.out.println("vs");

        IntStream.range(1950, 2150)
            .filter(y -> (y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            .forEach(System.out::println);
    }

    public static boolean isLeapYear(int year) {
        boolean every4Years = year % 4 == 0;
        boolean notEvery100Years = year % 100 != 0;
        boolean every400Years = year % 400 == 0;

        return (every4Years && notEvery100Years) || every400Years;
    }

    public static void orderMatters() {
        int fastNumber = IntStream.range(1950, 2150)
                .filter(n -> n == 2000)
                .map(StreamsGoodPractices::timeConsumingTransformation)
                .sum();

        System.out.println("fast " + fastNumber);

        int slowNumber = IntStream.range(1950, 2150)
                .map(StreamsGoodPractices::timeConsumingTransformation)
                .filter(n -> n == 2000)
                .sum();

        System.out.println("slow " + slowNumber);
    }

    public static int timeConsumingTransformation(int number) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }
}
