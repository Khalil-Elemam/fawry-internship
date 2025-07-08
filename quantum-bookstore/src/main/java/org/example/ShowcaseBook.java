package org.example;

import java.time.Year;

public class ShowcaseBook extends Book {

    public ShowcaseBook(
        String isbn,
        String title,
        Year year,
        double price
    ) {
        super(isbn, title, year, price);
    }

    @Override
    public boolean isAvailableForPurchase() {
        return false;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Quantum book store: Showcase books are not available for purchase");
    }

    @Override
    public String getBookType() {
        return "Showcase/Demo Book";
    }

    @Override
    public String toString() {
        return String.format("ShowcaseBook{isbn='%s', title='%s', year=%s, price=%.2f}",
                           isbn, title, year, price);
    }
}
