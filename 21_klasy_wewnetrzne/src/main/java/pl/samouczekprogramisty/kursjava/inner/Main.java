package pl.samouczekprogramisty.kursjava.inner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        innerClassInstantiation();
        staticInnerClassInstantiation();
        localClassInstantiation(args);
        mapIterationExampe();
    }

    private static void mapIterationExampe() {
        Map<String, Integer> dayInMonths = new HashMap<>();
        dayInMonths.put("styczen", 31);
        dayInMonths.put("luty", 28);
        dayInMonths.put("marzec", 31);

        for(Map.Entry<String, Integer> entry : dayInMonths.entrySet()) {
            System.out.println(entry.getKey() + " ma " + entry.getValue() + " dni.");
        }
    }

    private static void localClassInstantiation(String[] args) {
        class LocalClass {
            @Override
            public String toString() {
                return "Argumenty metody: " + Arrays.toString(args);
            }
        }
        LocalClass localClassInstance = new LocalClass();
        System.out.println(localClassInstance);
    }

    private static void innerClassInstantiation() {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass instance1 = outerClass.instantiate();
        OuterClass.InnerClass instance2 = outerClass.new InnerClass();
    }

    private static void staticInnerClassInstantiation() {
        OuterClass2 outerClass = new OuterClass2();
        OuterClass2.InnerClass2 instance1 = outerClass.instantiate();
        OuterClass2.InnerClass2 instance2 = new OuterClass2.InnerClass2();
    }
}