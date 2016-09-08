package pl.samouczekprogramisty.kursjava.enums.simple;

public class Tshirt {
    private TshirtSize size;
    private String manufacturer;

    public Tshirt(TshirtSize size, String manufacturer) {
        this.size = size;
        this.manufacturer = manufacturer;
    }

    public static void main(String[] args) {
        Tshirt tshirt = new Tshirt(TshirtSize.L, "Polex");
        System.out.println(tshirt.size);

        System.out.println(TshirtSize.L == TshirtSize.L);
        System.out.println(TshirtSize.L.equals(TshirtSize.L));

        switch (tshirt.size) {
            case S:
                System.out.println("Kupiles koszulke w rozmiarze small");
                break;
            case M:
                System.out.println("Kupiles koszulke w rozmiarze medium");
                break;
            case L:
                System.out.println("Kupiles koszulke w rozmiarze large");
                break;
            case XL:
                System.out.println("Kupiles koszulke w rozmiarze extra large");
                break;
        }
    }
}
