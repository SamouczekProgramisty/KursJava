package pl.samouczekprogramisty.kursjava.streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) throws FileNotFoundException {
        Stream<Integer> stream1 = new LinkedList<Integer>().stream();
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{});
        Stream<String> stream3 = Pattern.compile(".").splitAsStream("some longer sentence");

        DoubleStream doubles = DoubleStream.of(1, 2, 3);
        IntStream ints = IntStream.range(0, 123);
        LongStream longs = LongStream.generate(() -> 1L);

        DoubleStream randomDoubles = new Random().doubles();
        IntStream randomInts = new Random().ints();
        LongStream randomLongs = new Random().longs();

        Stream.empty();

        try (Stream<String> lines = new BufferedReader(new FileReader("file.txt")).lines()) {
            //
        }
    }

}
