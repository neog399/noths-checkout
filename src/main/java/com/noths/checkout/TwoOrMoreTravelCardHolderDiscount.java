package com.noths.checkout;

import java.util.List;

public class TwoOrMoreTravelCardHolderDiscount implements Discount {
    // Make it configurable (via ctor parameter) if needed
    // You could also make the product type and quantity configurable
    private static final double REDUCED_TRAVEL_CARD_HOLDER_PRICE = 8.5;

    @Override
    public double apply(List<Product> items) {
        long numOfTravelCardHolders = items.stream()
                .filter(item -> item.getCode().equals(Product.TRAVEL_CARD_HOLDER.getCode()))
                .count();
        if (numOfTravelCardHolders < 2) {
            return 0.0;
        }

        return numOfTravelCardHolders * (Product.TRAVEL_CARD_HOLDER.getPrice() - REDUCED_TRAVEL_CARD_HOLDER_PRICE);
    }
}
