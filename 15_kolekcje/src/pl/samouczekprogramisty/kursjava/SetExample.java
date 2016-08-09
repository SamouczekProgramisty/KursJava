package pl.samouczekprogramisty.kursjava;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> setWithNames = new HashSet<>();
        setWithNames.add("Marcin");
        setWithNames.add("Marek");
        setWithNames.add("Marcin");

        Set<String> otherSet = new HashSet<>();
        otherSet.add("Zenon");
        otherSet.add("Marek");

        setWithNames.addAll(otherSet);

        System.out.println(setWithNames.isEmpty());
        System.out.println(setWithNames.size());
        System.out.println(setWithNames.contains("Marcin"));
        System.out.println(setWithNames.remove("Janusz"));
    }
}
