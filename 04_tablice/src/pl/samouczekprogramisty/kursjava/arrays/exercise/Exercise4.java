package pl.samouczekprogramisty.kursjava.arrays.exercise;


public class Exercise4 {
    // Sa lepsze sposoby, jednak na tym etapie taki sposob jest OK :)
    // Jesli jestes ciekawy jak zrobic to lepiej poczytaj o typie wyliczeniowym.
    // http://www.samouczekprogramisty.pl/typ-wyliczeniowy-w-jezyku-java/
    public static final int EMPTY = 0;
    public static final int B_PAWN = 1;
    public static final int B_ROOK = 2;
    public static final int B_BISHOP = 3;
    public static final int B_KNIGHT = 4;
    public static final int B_QUEEN = 5;
    public static final int B_KING = 6;

    public static final int W_PAWN = 7;
    public static final int W_ROOK = 8;
    public static final int W_BISHOP = 9;
    public static final int W_KNIGHT = 10;
    public static final int W_QUEEN = 11;
    public static final int W_KING = 12;

    private int[][] board = new int[8][8];

    public static int[][] game5FinalState() {
        return new int[][] {
            new int[] {EMPTY,    EMPTY,    EMPTY,    EMPTY,    EMPTY,   EMPTY,    EMPTY,    EMPTY},
            new int[] {B_PAWN,   B_PAWN,   EMPTY,    EMPTY,    EMPTY,   EMPTY,    W_PAWN,   EMPTY},
            new int[] {EMPTY,    EMPTY,    EMPTY,    EMPTY,    EMPTY,   EMPTY,    EMPTY,    EMPTY},
            new int[] {EMPTY,    EMPTY,    EMPTY,    EMPTY,    EMPTY,   EMPTY,    EMPTY,    EMPTY},
            new int[] {EMPTY,    B_KING,   B_PAWN,   EMPTY,    EMPTY,   W_KNIGHT, EMPTY,    EMPTY},
            new int[] {EMPTY,    B_KNIGHT, EMPTY,    EMPTY,    W_ROOK,  EMPTY,    W_PAWN,   EMPTY},
            new int[] {EMPTY,    EMPTY,    EMPTY,    B_ROOK,   EMPTY,   EMPTY,    EMPTY,    EMPTY},
            new int[] {EMPTY,    W_KING,   EMPTY,    EMPTY,    EMPTY,   EMPTY,    EMPTY,    EMPTY},
        };
    }

}
