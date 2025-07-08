package org.example;

import java.time.Year;
import java.util.*;

public class BookStore {
    private final Map<String, Book> inventory;

    public BookStore() {
        this.inventory = new HashMap<>();
    }


    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added " + book.getBookType() + " - " + book.getTitle() + " to inventory");
    }


    public List<Book> removeOutdatedBooks(Year thresholdYear) {
        List<Book> outdatedBooks = new ArrayList<>();

        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            if (book.getYear().isBefore(thresholdYear)) {
                outdatedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book.getTitle() +
                                 " (Published: " + book.getYear() + ")");
            }
        }

        return outdatedBooks;
    }


    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Book with ISBN " + isbn + " not found in inventory");
        }

        // Check if the book is purchasable
        if (!(book instanceof Purchasable purchasableBook)) {
            throw new IllegalArgumentException("Quantum book store: Book " + book.getTitle() + " is not available for purchase");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantum book store: Quantity must be positive");
        }

        purchasableBook.processPurchase(quantity, email, address);

        double totalAmount = book.getPrice() * quantity;
        System.out.println("Quantum book store: Purchase successful! Total amount: $" +
                         String.format("%.2f", totalAmount));

        return totalAmount;
    }


    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }


    public Collection<Book> getAllBooks() {
        return inventory.values();
    }


    public void displayInventory() {
        System.out.println("\nQuantum book store: Current Inventory:");
        System.out.println("====================================");

        if (inventory.isEmpty()) {
            System.out.println("Quantum book store: No books in inventory");
            return;
        }

        for (Book book : inventory.values()) {
            System.out.println("Quantum book store: " + book);
        }
    }


}
