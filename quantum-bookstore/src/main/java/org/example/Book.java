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

    public abstract String getBookType();

    @Override
    public String toString() {
        return String.format("Book{isbn='%s', title='%s', year=%s, price=%.2f}",
                           isbn, title, year, price);
    }
}
