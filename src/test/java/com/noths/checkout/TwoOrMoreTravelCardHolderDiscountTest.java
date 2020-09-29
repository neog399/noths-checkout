package com.noths.checkout;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoOrMoreTravelCardHolderDiscountTest {
    private final TwoOrMoreTravelCardHolderDiscount discount = new TwoOrMoreTravelCardHolderDiscount();

    @Test
    public void returnsZeroIfNoItemsWereGiven() {
        assertEquals(0.0, discount.apply(Collections.emptyList()), 0.1);
    }

    @Test
    public void returnsZeroIfNoTravelCardHolderWasGiven() {
        List<Product> items = Arrays.asList(
                new Product("9999", "item name", 25.0),
                new Product("9998", "item name", 25.0)
        );
        assertEquals(0.0, discount.apply(items), 0.1);
    }

    @Test
    public void returnsZeroIf1TravelCardHolderWasGiven() {
        List<Product> items = Arrays.asList(
                new Product("0000", "item name", 25.0),
                Product.TRAVEL_CARD_HOLDER,
                new Product("0000", "item name", 25.0)
        );
        assertEquals(0.0, discount.apply(items), 0.1);
    }

    @Test
    public void returns1_50If2TravelCardHoldersWereGiven() {
        List<Product> items = Arrays.asList(
                new Product("0000", "item name", 25.0),
                Product.TRAVEL_CARD_HOLDER,
                new Product("0000", "item name", 25.0),
                Product.TRAVEL_CARD_HOLDER
        );
        assertEquals(1.5, discount.apply(items), 0.1);
    }

    @Test
    public void returns2_25If3TravelCardHoldersWereGiven() {
        List<Product> items = Arrays.asList(
                new Product("0000", "item name", 25.0),
                Product.TRAVEL_CARD_HOLDER,
                new Product("0000", "item name", 25.0),
                Product.TRAVEL_CARD_HOLDER,
                Product.TRAVEL_CARD_HOLDER
        );
        assertEquals(2.25, discount.apply(items), 0.1);
    }
}