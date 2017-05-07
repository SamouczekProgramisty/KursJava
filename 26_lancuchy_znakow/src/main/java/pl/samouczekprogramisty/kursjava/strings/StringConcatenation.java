package pl.samouczekprogramisty.kursjava.strings;

public class StringConcatenation {

    public void intermediaryStringObjects() {
        String some = "some";
        String space = " ";
        String random = "random";
        String string = "string";

        String someString = some + space + random + space + string;
    }

    public void plusSingnBehaviour() {
        System.out.println(1 + 2 + "test"); // 3test
        System.out.println("test" + 1 + 2); // test12
    }

    public void compilerConcatenationFiddling() {
        String some = "some";
        String space = " ";
        String random = "random";
        String string = "string";

        StringBuilder x = new StringBuilder();
        x.append(some);
        x.append(space);
        x.append(random);
        x.append(space);
        x.append(string);

        String someString = x.toString();
    }

    public void loopWithoutCompilerIngerence() {
        String finalString = "";
        for (int counter = 0; counter < 1000000; counter++) {
            finalString = finalString + " " + counter;
        }
    }

    public void loopWithCompilerIngerence() {
        String finalString = "";
        for (int counter = 0; counter < 1000000; counter++) {
            StringBuilder x = new StringBuilder();
            x.append(finalString);
            x.append(" ");
            x.append(counter);
            finalString = x.toString();
        }
    }

    public void optimizedLoop() {
        StringBuilder finalStringBuilder = new StringBuilder();
        for (int counter = 0; counter < 1000000; counter++) {
            finalStringBuilder.append(" ");
            finalStringBuilder.append(counter);
        }
        String finalString = finalStringBuilder.toString();
    }
}
