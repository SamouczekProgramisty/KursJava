package pl.samouczekprogramisty.kursjava;

public class RuntimeType {
    public static void main(String[] args) {
        Object[] someMysteriousObjects =  new Object[] {"1234", new Object()};

        String castedString = (String) someMysteriousObjects[0];
        String classCastException = (String) someMysteriousObjects[1];
    }

    public void differentTypes() {
        Object objectInstance = new Object();
        Object stringInstance = "string";

        String realString = (String) stringInstance;
        realString.length();
    }
}
