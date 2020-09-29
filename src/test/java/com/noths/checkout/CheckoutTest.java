package com.noths.checkout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {
    private static final Product TRAVEL_CARD_HOLDER = new Product("001", "Travel Card Holder", 9.25);
    private static final Product PERSONALIZED_CUFFLINKS = new Product("002", "Personalised cufflinks", 45.00);
    private static final Product KIDS_T_SHIRT = new Product("003", "Kids T-shirt", 19.95);

    @Test
    public void returnsSumOfAllItemsScanned() {
        Checkout checkout = new Checkout();
        checkout.scan(TRAVEL_CARD_HOLDER);
        checkout.scan(PERSONALIZED_CUFFLINKS);
        checkout.scan(KIDS_T_SHIRT);
        assertEquals(74.2, checkout.total(), 0.1);

        checkout = new Checkout();
        checkout.scan(TRAVEL_CARD_HOLDER);
        checkout.scan(KIDS_T_SHIRT);
        checkout.scan(TRAVEL_CARD_HOLDER);
        assertEquals(38.45, checkout.total(), 0.1);

        checkout = new Checkout();
        checkout.scan(TRAVEL_CARD_HOLDER);
        checkout.scan(PERSONALIZED_CUFFLINKS);
        checkout.scan(TRAVEL_CARD_HOLDER);
        checkout.scan(KIDS_T_SHIRT);
        assertEquals(83.45, checkout.total(), 0.1);
    }
}