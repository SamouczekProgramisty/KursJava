package pl.samouczekprogramisty.kursjava.shop.exercise;

public final class Item implements Comparable<Item> {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || ! (otherObject instanceof Item)) {
            return false;
        }

        Item item = (Item) otherObject;

        if (Double.compare(item.price, price) != 0) {
            return false;
        }
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode();
    }

    @Override
    public int compareTo(Item other) {
        if (other == null) {
            return 1;
        }
        int comparision = this.getName().compareTo(other.getName());
        if (comparision != 0) {
            return comparision;
        }
        return Double.compare(this.getPrice(), other.getPrice());
    }
}
