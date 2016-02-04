package pl.samouczekprogramisty.kursjava;

public class ObjectFieldsChanging {
    private int attribute;

    public ObjectFieldsChanging(int attribute) {
        this.attribute = attribute;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public static void main(String[] args) {
        ObjectFieldsChanging reference1 = new ObjectFieldsChanging(123);
        ObjectFieldsChanging reference2 = reference1;

        System.out.println(reference1.getAttribute());
        System.out.println(reference2.getAttribute());

        reference1.setAttribute(1);

        System.out.println(reference1.getAttribute());
        System.out.println(reference2.getAttribute());

        reference2 = new ObjectFieldsChanging(3);
    }
}
