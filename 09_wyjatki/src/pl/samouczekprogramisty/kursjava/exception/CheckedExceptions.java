package pl.samouczekprogramisty.kursjava.exception;

import java.io.IOException;

public class CheckedExceptions {
    public static void main(String[] args) {
        CheckedExceptions instance = new CheckedExceptions();
        try {
            instance.methodWithCheckedException();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void methodWithCheckedException() throws IOException {
        throw new IOException();
    }
}
