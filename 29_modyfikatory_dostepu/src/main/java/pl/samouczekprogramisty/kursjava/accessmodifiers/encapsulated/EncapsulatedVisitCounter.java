package pl.samouczekprogramisty.kursjava.accessmodifiers.encapsulated;

public class EncapsulatedVisitCounter {

    private int userCount = 0;

    public void increment() {
        userCount++;
    }

    public int getUserCount() {
        return userCount;
    }
}
