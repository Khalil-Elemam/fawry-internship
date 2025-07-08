package org.example;

import java.time.Year;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected Year year;
    protected double price;

    public Book(String isbn, String title, Year year, double price) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Year getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public abstract boolean isAvailableForPurchase();
    public abstract void processPurchase(int quantity, String email, String address);
    public abstract String getBookType();

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
