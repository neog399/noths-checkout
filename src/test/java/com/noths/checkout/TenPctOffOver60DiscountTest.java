package com.noths.checkout;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TenPctOffOver60DiscountTest {
    private final TenPctOffOver60Discount discount = new TenPctOffOver60Discount();

    @Test
    public void returnsZeroIfNoItemsWereGiven() {
        assertEquals(0.0, discount.apply(Collections.emptyList()), 0.1);
    }

    @Test
    public void returnsZeroIfSumOfItemsIsBelow60() {
        List<Product> items = Arrays.asList(
                new Product("0000", "item name", 25.0),
                new Product("0000", "item name", 25.0),
                new Product("0000", "item name", 9.5)
        );
        assertEquals(0.0, discount.apply(items), 0.1);
    }

    @Test
    public void returnsZeroIfSumOfItemsIs60() {
        List<Product> items = Arrays.asList(
                new Product("0000", "item name", 25.0),
                new Product("0000", "item name", 25.0),
                new Product("0000", "item name", 10.0)
        );
        assertEquals(0.0, discount.apply(items), 0.1);
    }

    @Test
    public void returnsRoughly6IfSumOfItemsIsJustAbove60() {
        List<Product> items = Arrays.asList(
                new Product("0000", "item name", 25.0),
                new Product("0000", "item name", 25.0),
                new Product("0000", "item name", 10.5)
        );
        assertEquals(6.05, discount.apply(items), 0.1);
    }

    @Test
    public void returns8IfSumOfItemsIs80() {
        List<Product> items = Arrays.asList(
                new Product("0000", "item name", 25.0),
                new Product("0000", "item name", 25.0),
                new Product("0000", "item name", 30.0)
        );
        assertEquals(8.0, discount.apply(items), 0.1);
    }
}