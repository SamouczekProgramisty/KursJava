package pl.samouczekprogramisty.kursjava.junit5.unit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SamouczekExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        System.out.println("Samouczek extension :)");
    }
}
