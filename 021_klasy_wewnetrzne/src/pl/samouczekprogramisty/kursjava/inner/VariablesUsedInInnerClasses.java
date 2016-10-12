package pl.samouczekprogramisty.kursjava.inner;

public class VariablesUsedInInnerClasses {
    public static void main(String[] args) {
        final String finalVariable = "final variable";
        String effectivelyFinalVariable = "effectively final variable";
        String nonFinalVariable = "non final variable";

        class InnerClass {
            public void saySomething() {
                System.out.println(finalVariable);
                System.out.println(effectivelyFinalVariable);
            }
        }

        InnerClass instance = new InnerClass();
        instance.saySomething();

        nonFinalVariable = "new value";
    }
}
