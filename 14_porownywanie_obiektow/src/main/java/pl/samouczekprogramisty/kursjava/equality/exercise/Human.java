package pl.samouczekprogramisty.kursjava.equality.exercise;

public class Human {
    private final String name;
    private final String surname;
    private final String pesel;

    public Human(String name, String surname, String pesel) {
        this.name = name;
        this.surname = surname;
        if (pesel == null) {
            throw new IllegalArgumentException("Every human needs to have PESEL!");
        }
        this.pesel = pesel;
    }

    @Override
    public int hashCode() {
        return 17 * pesel.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Human)) {
            return false;
        }

        Human otherHuman = (Human) obj;
        return pesel.equals(otherHuman.getPesel());
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + pesel;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPesel() {
        return pesel;
    }

    public static void main(String[] args) {
        Human human1 = new Human("Jan", "Kowalski", "850223000000");
        Human human2 = new Human("Jan", "Kowalski", "891213000000");
        Human human3 = new Human("Jan", "Kowalski", "850223000000");

        System.out.println(human1 + " == " + human2 + " " + human1.equals(human2));
        System.out.println(human2 + " == " + human3 + " " + human2.equals(human3));
        System.out.println(human1 + " == " + human3 + " " + human1.equals(human3));
    }
}
