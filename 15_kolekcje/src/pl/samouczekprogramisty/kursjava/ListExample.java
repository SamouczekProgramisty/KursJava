package pl.samouczekprogramisty.kursjava;


import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> listWithNames = new LinkedList<>();
        listWithNames.add("Piotrek");
        listWithNames.add("Krzysiek");

        List<String> otherListWithNames = new LinkedList<>();
        otherListWithNames.add("Marek");
        otherListWithNames.addAll(listWithNames);
        otherListWithNames.add("Marek");

        System.out.println(otherListWithNames.contains("Marek"));
        System.out.println(otherListWithNames.get(0));
        System.out.println(otherListWithNames.isEmpty());
        System.out.println(otherListWithNames.size());
        System.out.println(otherListWithNames.indexOf("Marek"));
        System.out.println(otherListWithNames.lastIndexOf("Marek"));
    }


}
