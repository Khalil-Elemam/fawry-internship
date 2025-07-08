package org.example;

import java.time.Year;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(
        String isbn,
        String title,
        Year year,
        double price,
        int stock
    ) {
        super(isbn, title, year, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Quantum book store: Not enough stock available. Available: " + stock + ", Requested: " + quantity);
        }
        stock -= quantity;
    }

    @Override
    public boolean isAvailableForPurchase() {
        return stock > 0;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        reduceStock(quantity);
        ShippingService.ship(this, quantity, address);
    }

    @Override
    public String getBookType() {
        return "Paper Book";
    }

    @Override
    public String toString() {
        return String.format("PaperBook{isbn='%s', title='%s', year=%s, price=%.2f, stock=%d}",
                           isbn, title, year, price, stock);
    }
}
