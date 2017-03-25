package pl.samouczekprogramisty.kursjava;

public class ObjectVersusReference {
    public static void main(String[] args) {
        Object referenceToObjectX = new Object();
        Object anotherReferenceToObjectX = referenceToObjectX;
        Object refferenceToObjectY = new Object();

        System.out.println(referenceToObjectX.toString());
        System.out.println(anotherReferenceToObjectX.toString());
        System.out.println(refferenceToObjectY.toString());
    }
}
