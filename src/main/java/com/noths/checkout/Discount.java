package com.noths.checkout;

import java.util.List;

public interface Discount {
    double calculate(List<Product> items, double subtotal);
}
