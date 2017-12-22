package pl.samouczekprogramisty.kursjava.inner;

public class AnonymousCheating {

    private interface SomeInterface {
        void doSomethingUseful();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        SomeInterface anonymousInstance = new SomeInterface() {
            @Override
            public void doSomethingUseful() {
                System.out.println("I'm doing something useful!");
            }
        };

        anonymousInstance.doSomethingUseful();
        cheatCompiler(anonymousInstance.getClass());
    }

    private static void cheatCompiler(Class<? extends SomeInterface> anonymousClass) throws IllegalAccessException, InstantiationException {
        SomeInterface otherInstance1 = anonymousClass.newInstance();
        SomeInterface otherInstance2 = anonymousClass.newInstance();

        System.out.println(otherInstance1 == otherInstance2);
    }

}