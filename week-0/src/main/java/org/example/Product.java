package org.example;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Base class for all products in the e-commerce system
 */
public class Product {
    private String name;
    private double price;
    private int quantity;

    // no expiration date by default
    private LocalDate expiryDate;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price, int quantity, LocalDate expiryDate) {
        this(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(expiryDate, product.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, expiryDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
