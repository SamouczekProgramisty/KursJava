package pl.samouczekprogramisty.kursjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IterationExample {
    public static void main(String[] args) {
        System.out.println("# List");
        iterateList();

        System.out.println("# Set");
        iterateSet();

        System.out.println("# Map");
        iterateMap();
    }

    private static void iterateMap() {
        Map<String, String> sampleMap = new HashMap<>();
        sampleMap.put("Marek", "Magda");
        sampleMap.put("Marcin", "Adela");

        System.out.println("Iterowanie po wartosciach");
        for(String value : sampleMap.values()) {
            System.out.println(value);
        }

        System.out.println("Iterowanie po kluczach i pobieranie wartosci");
        for(String key : sampleMap.keySet()) {
            String value = sampleMap.get(key);
            System.out.println(key + ": " + value);
        }

        System.out.println("Iterowanie po kluczach i wartosciach");
        for(Map.Entry<String, String> entry : sampleMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }

    private static void iterateSet() {
        Set<String> sampleSet = new HashSet<>();
        sampleSet.add("Marcin");
        sampleSet.add("Adela");
        sampleSet.add("Marek");
        sampleSet.add("Magda");

        System.out.println("Iterowanie po zbiorze");
        for(String item : sampleSet) {
            System.out.println(item);
        }
    }

    private static void iterateList() {
        List<String> sampleList = new ArrayList<>();
        sampleList.add("Marcin");
        sampleList.add("Adela");
        sampleList.add("Marek");
        sampleList.add("Magda");

        System.out.println("Iterowanie po liscie (foreach)");
        for(String item : sampleList) {
            System.out.println(item);
        }

        System.out.println("Iterowanie po liscie (for)");
        for(int index = 0; index < sampleList.size(); index++) {
            System.out.println(sampleList.get(index));
        }
    }
}
