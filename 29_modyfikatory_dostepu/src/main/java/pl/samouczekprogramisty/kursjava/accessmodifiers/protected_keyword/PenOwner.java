package pl.samouczekprogramisty.kursjava.accessmodifiers.protected_keyword;

public class PenOwner {

    private Pen pen;

    public PenOwner(Pen pen) {
        this.pen = pen;
    }

    @Override
    public String toString() {
        return "Mam pioro w kolorze " + pen.color;
    }
}
