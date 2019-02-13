package pl.samouczekprogramisty.kursjava.primitivetypes;


public class PrimitiveTypes {
    public static void main(String[] args) {
        byte b1 = 10;
        Byte b2 = Byte.valueOf((byte) 10);
        Byte b3 = 10;

        short s1 = 10;
        Short s2 = Short.valueOf((short) 10);
        Short s3 = 10;

        int i1 = 10;
        Integer i2 = Integer.valueOf(10);
        Integer i3 = 10;

        long l1 = 10L;
        Long l2 = Long.valueOf(10L);
        Long l3 = 10L;
        long l4 = l2;

        boolean bo1 = true;
        Boolean bo2 = Boolean.valueOf(true);
        Boolean bo3 = true;

        char c1 = 'c';
        Character c2 = Character.valueOf('c');
        Character c3 = 'c';

        float f1 = 1.2F;
        Float f2 = Float.valueOf(1.2F);
        Float f3 = 1.2F;

        double d1 = 1.2;
        Double d2 = Double.valueOf(1.2);
        Double d3 = 1.2;
    }
}
