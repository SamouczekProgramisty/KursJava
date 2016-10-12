package pl.samouczekprogramisty.kursjava.inner.exercise;

import pl.samouczekprogramisty.kursjava.inner.AnonymousClasses;

public class HansRobot {
    public static void main(String[] args) {
        AnonymousClasses.Robot hans = new AnonymousClasses.Robot(new AnonymousClasses.GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("guten morgen");
            }
        });

        hans.saySomething();
    }
}
