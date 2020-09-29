package com.noths.checkout;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    // Assumption is the Checkout class will be used by 1 thread at a time
    // If multi-threaded access is needed then we either need to make this stateless (i.e. pass the whole item list)
    // Or make this list thread safe (i.e. synchronize it or use an implementation that locks internally)
    private final List<Product> items = new ArrayList<>();

    public void scan(Product item) {
        items.add(item);
    }

    public double total() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}
