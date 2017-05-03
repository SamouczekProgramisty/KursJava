package pl.samouczekprogramisty.kursjava.shop.exercise;


import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    protected static final String ITEM_ORDER_FORMAT = "%s (%.2f x %d = %.2f)";

    private final Map<Item, Integer> order = new TreeMap<>();

    public void add(Item item) {
        add(item, 1);
    }

    public void add(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(String.format("Illegal quantity %d!", quantity));
        }
        if (order.containsKey(item)) {
            quantity = order.get(item) + quantity;
        }
        order.put(item, quantity);
    }

    public void remove(Item item) {
        remove(item, 1);
    }

    public void remove(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(String.format("Illegal quantity %d!", quantity));
        }
        quantity = order.get(item) - quantity;
        if (quantity == 0) {
            order.remove(item);
        }
        else if (quantity < 0) {
            throw new IllegalStateException(String.format("There is no that many items to remove~"));
        }
        else {
            order.put(item, quantity);
        }
    }

    public double getOrderValue() {
        double orderValue = 0;

        for(Map.Entry<Item, Integer> itemOrder : order.entrySet()) {
            orderValue += itemOrder.getKey().getPrice() * itemOrder.getValue();
        }

        return orderValue;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(Map.Entry<Item, Integer> itemOrder : order.entrySet()) {
            Item item = itemOrder.getKey();
            Integer quantity = itemOrder.getValue();
            String itemString = String.format(
                    ITEM_ORDER_FORMAT,
                    item.getName(),
                    item.getPrice(),
                    quantity,
                    item.getPrice() * quantity
            );
            result.append(itemString);
            result.append(System.lineSeparator());
        }
        result.append(String.format("Total: %.2f", getOrderValue()));

        return result.toString();
    }

    public Map<Item, Integer> getOrder() {
        return Collections.unmodifiableMap(order);
    }
}