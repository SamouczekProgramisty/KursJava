package pl.samouczekprogramisty.kursjava.inner;

import java.lang.reflect.InvocationTargetException;

public class AnonymousCheating {

    private interface SomeInterface {
        void doSomethingUseful();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        SomeInterface anonymousInstance = new SomeInterface() {
            @Override
            public void doSomethingUseful() {
                System.out.println("I'm doing something useful!");
            }
        };

        anonymousInstance.doSomethingUseful();
        System.out.println(anonymousInstance.getClass());
    }
}