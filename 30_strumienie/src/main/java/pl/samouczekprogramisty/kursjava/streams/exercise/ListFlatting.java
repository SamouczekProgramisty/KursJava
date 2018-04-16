package pl.samouczekprogramisty.kursjava.streams.exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListFlatting {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("a", "b", "c"),
                Arrays.asList("A", "B", "C"),
                Arrays.asList("!", "@", "#")
        );
        List<String> flatten = flatten(listOfLists);
        System.out.println(flatten);
    }

    private static <T> List<T> flatten(List<List<T>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
