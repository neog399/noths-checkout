package com.noths.checkout;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class TenPctOffOver60DiscountTest {
    private final TenPctOffOver60Discount discount = new TenPctOffOver60Discount();

    @Test
    public void returnsZeroIfSubtotalIsBelow60() {
        assertEquals(0.0, discount.apply(Collections.emptyList(), 59.5), 0.1);
    }

    @Test
    public void returnsZeroIfSubTotalIs60() {
        assertEquals(0.0, discount.apply(Collections.emptyList(), 60.0), 0.1);
    }

    @Test
    public void returnsRoughly6IfSubTotalIsJustAbove60() {
        assertEquals(6.05, discount.apply(Collections.emptyList(), 60.5), 0.1);
    }

    @Test
    public void returns8IfSubTotalIs80() {
        assertEquals(8.0, discount.apply(Collections.emptyList(), 80.0), 0.1);
    }
}