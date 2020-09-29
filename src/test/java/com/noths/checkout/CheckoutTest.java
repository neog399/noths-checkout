package com.noths.checkout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {
    @Test
    public void returnsSumOfAllItemsScanned() {
        Checkout checkout = new Checkout();
        checkout.scan(Product.TRAVEL_CARD_HOLDER);
        checkout.scan(Product.PERSONALIZED_CUFFLINKS);
        checkout.scan(Product.KIDS_T_SHIRT);
        assertEquals(74.2, checkout.total(), 0.1);

        checkout = new Checkout();
        checkout.scan(Product.TRAVEL_CARD_HOLDER);
        checkout.scan(Product.KIDS_T_SHIRT);
        checkout.scan(Product.TRAVEL_CARD_HOLDER);
        assertEquals(38.45, checkout.total(), 0.1);

        checkout = new Checkout();
        checkout.scan(Product.TRAVEL_CARD_HOLDER);
        checkout.scan(Product.PERSONALIZED_CUFFLINKS);
        checkout.scan(Product.TRAVEL_CARD_HOLDER);
        checkout.scan(Product.KIDS_T_SHIRT);
        assertEquals(83.45, checkout.total(), 0.1);
    }
}