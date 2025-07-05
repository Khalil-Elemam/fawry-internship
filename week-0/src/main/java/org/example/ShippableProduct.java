package org.example;


import java.time.LocalDate;


/**
 * In my opinion, implementing an interface isn't necessary,
 * but I've done that to achieve the requirements
 */
public class ShippableProduct extends Product implements Shippable {

    // weight in grams
    private final double weight;

    public ShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
