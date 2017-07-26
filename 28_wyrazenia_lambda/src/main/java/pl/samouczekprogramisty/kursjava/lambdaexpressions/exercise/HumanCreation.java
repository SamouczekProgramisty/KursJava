package pl.samouczekprogramisty.kursjava.lambdaexpressions.exercise;

import java.util.function.BiFunction;

public class HumanCreation {

    public static void main(String[] args) {
        BiFunction<Integer, String, Human> humanConstructor = Human::new;
        Human human = humanConstructor.apply(25, "Zenek");
        System.out.println(human.getAge());
        System.out.println(human.getName());
    }

}
