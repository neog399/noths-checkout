package com.noths.checkout;

public class Product {
    private final String code;
    private final String name;
    // Due to issues with floating point arithmetics, you should change this to BigDecimal in a production system
    // Or better yet, use a purpose-built library, like Money from JavaMoney Moneta
    private final double price;

    // Depending on your requirements, you might want to validate your inputs here
    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
