package pl.samouczekprogramisty.kursjava.lambdaexpressions.exercise;

public class HumanCreation {

    @FunctionalInterface
    private interface HumanFactory {
        Human instantiate(int age, String name);
    }

    public static void main(String[] args) {
        HumanFactory humanConstructor = Human::new;
        Human human = humanConstructor.instantiate(25, "Zenek");
        System.out.println(human.getAge());
        System.out.println(human.getName());
    }

}
