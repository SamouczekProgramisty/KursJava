package pl.samouczekprogramisty.kursjava;

import java.util.Random;

/**
 * Created by mapi on 24.11.15.
 */
public class PrimitiveTypes {

    public static void main(String[] args) {
        byte b1 = 10;
        Byte b2 = new Byte((byte) 10);
        Byte b3 = 10;

        short s1 = 10;
        Short s2 = new Short((short) 10);
        Short s3 = 10;

        int i1 = 10;
        Integer i2 = new Integer(10);
        Integer i3 = 10;

        long l1 = 10L;
        Long l2 = new Long(10L);
        Long l3 = 10L;
        long l4 = l2;

        boolean bo1 = true;
        Boolean bo2 = new Boolean(true);
        Boolean bo3 = true;

        char c1 = 'c';
        Character c2 = new Character('c');
        Character c3 = 'c';

        float f1 = 1.2F;
        Float f2 = new Float(1.2F);
        Float f3 = 1.2F;

        double d1 = 1.2;
        Double d2 = new Double(1.2);
        Double d3 = 1.2;
    }
}
