package com.noths.checkout;

import java.util.List;

public interface Discount {
    double apply(List<Product> items);
}
