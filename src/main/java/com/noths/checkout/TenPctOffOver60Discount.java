package com.noths.checkout;

import java.util.List;

public class TenPctOffOver60Discount implements Discount {
    @Override
    public double apply(List<Product> items, double subtotal) {
        if (subtotal <= 60.0) {
            return 0.0;
        }

        return subtotal / 10;
    }
}
