package com.noths.checkout;

import java.util.List;

public class TenPctOffOver60Discount implements Discount {
    @Override
    public double apply(List<Product> items, double _subtotal) {
        // Same piece of code as in Checkout. Pass subtotal to Discount if this keeps coming up to avoid duplication.
        double subtotal = items.stream().mapToDouble(Product::getPrice).sum();
        if (subtotal <= 60.0) {
            return 0.0;
        }

        return subtotal / 10;
    }
}
