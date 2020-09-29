package com.noths.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Checkout {
    // The order in which discounts are applied *is* important here, hence using List
    private final List<Discount> discounts;

    // Assumption is the Checkout class will be used by 1 thread at a time
    // If multi-threaded access is needed then we either need to make this stateless (i.e. pass the whole item list)
    // Or make this list thread safe (i.e. synchronize it or use an implementation that locks internally)
    private final List<Product> items = new ArrayList<>();

    public Checkout(Discount... discounts) {
        this.discounts = Arrays.asList(discounts);
    }

    public void scan(Product item) {
        items.add(item);
    }

    public double total() {
        double total = items.stream().mapToDouble(Product::getPrice).sum();
        for (Discount discount : discounts) {
            total -= discount.calculate(items, total);
        }
        return total;
    }
}
