package pl.samouczekprogramisty.kursjava.shop.exercise;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class BasketTest {

    private static final double PRICE_DELTA = 0.001;

    private Basket basket;
    private Item toy;

    @Before
    public void setUp() {
        toy = new Item("toy", 39.99);
        basket = new Basket();
    }

    @Test
    public void shouldAllowToAddItemToBasket() {
        basket.add(toy);

        Map<Item, Integer> expected = createOrder(toy, 1);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldAllowToAddTheSameItemTwice() {
        basket.add(toy);
        basket.add(toy);

        Map<Item, Integer> expected = createOrder(toy, 2);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldAllowToAddItemWithQuantityOne() {
        basket.add(toy, 1);

        Map<Item, Integer> expected = createOrder(toy, 1);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldAllowToAddItemWithQuantityMany() {
        basket.add(toy, 34);

        Map<Item, Integer> expected = createOrder(toy, 34);

        assertEquals(expected, basket.getOrder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAllowToAddItemWithQuantityZero() {
        basket.add(toy, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAllowToAddItemWithNegativeQuantity() {
        basket.add(toy, -10);
    }

    @Test
    public void shouldAllowToRemoveItemFromBasket() {
        basket.add(toy, 2);
        basket.remove(toy);

        Map<Item, Integer> expected = createOrder(toy, 1);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldRemoveAllItemsFromBasket() {
        basket.add(toy);
        basket.remove(toy);

        Map<Item, Integer> expected = Collections.emptyMap();

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldAllowToRemove2ItemsAtOnce() {
        basket.add(toy, 3);
        basket.remove(toy, 2);

        Map<Item, Integer> expected = createOrder(toy, 1);

        assertEquals(expected, basket.getOrder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTrowExcptionWhenRemoving0Items() {
        basket.remove(toy, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTrowExcptionWhenRemovingNegativeQuantity() {
        basket.remove(toy, -10);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenThereIsNoThatManyitemsToRemove() {
        basket.add(toy, 1);
        basket.remove(toy, 2);
    }

    @Test
    public void shouldComputeSimpleOrderValue() {
        basket.add(toy, 3);

        double expectedValue = toy.getPrice() * 3;

        assertEquals(expectedValue, basket.getOrderValue(), PRICE_DELTA);
    }

    @Test
    public void shouldComputeOrderWithManyItemsValue() {
        Item teddyBear = new Item("teddy bear", 59.99);
        basket.add(toy, 3);
        basket.add(teddyBear, 4);

        double expectedValue = toy.getPrice() * 3 + teddyBear.getPrice() * 4;

        assertEquals(expectedValue, basket.getOrderValue(), PRICE_DELTA);
    }

    @Test
    public void shouldPrintSimpleOrder() {
        basket.add(toy, 2);

        StringBuilder expectedValue = new StringBuilder();

        expectedValue.append(String.format(Basket.ITEM_ORDER_FORMAT, toy.getName(), toy.getPrice(), 2, toy.getPrice() * 2));
        expectedValue.append(System.lineSeparator());
        expectedValue.append(String.format("Total: %.2f", 79.98));

        assertEquals(expectedValue.toString(), basket.toString());
    }

    @Test
    public void shouldDifferentiateBetweenToysWithSameNameDifferentPrice() {
        basket.add(new Item("otherToy", 10));
        basket.add(new Item("otherToy", 20));

        StringBuilder expectedValue = new StringBuilder();

        expectedValue.append(String.format(Basket.ITEM_ORDER_FORMAT, "otherToy", 10.0, 1, 10.0));
        expectedValue.append(System.lineSeparator());
        expectedValue.append(String.format(Basket.ITEM_ORDER_FORMAT, "otherToy", 20.0, 1, 20.0));
        expectedValue.append(System.lineSeparator());
        expectedValue.append(String.format("Total: %.2f", 30.0));

        assertEquals(expectedValue.toString(), basket.toString());
    }

    private static Map<Item, Integer> createOrder(Object ... mapContent) {
        Map<Item, Integer> result = new HashMap<>();

        for (int index = 0; index < mapContent.length; index += 2) {
            Item item = (Item) mapContent[index];
            Integer quantity = (Integer) mapContent[index + 1];
            result.put(item, quantity);
        }

        return result;
    }
}