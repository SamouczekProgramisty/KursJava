package pl.samouczekprogramisty.kursjava.annotations;

import java.util.ArrayList;
import java.util.List;

public class AnnotationsForCompiler {
    public static void main(String[] args) {
        List listOfUndefinedObjects = new ArrayList();
        @SuppressWarnings("uncecked")
        List<Integer> listOfIntegers = (List<Integer>) listOfUndefinedObjects;
    }
}
