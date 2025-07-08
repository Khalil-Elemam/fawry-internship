package org.example;

import java.time.Year;
import java.util.*;

public class BookStore {
    private final List<Book> INVENTORY;

    public BookStore() {
        this.INVENTORY = new ArrayList<>();
    }



    public void addBook(Book book) {
        INVENTORY.add(book);
        System.out.println("Quantum book store: Added " + book.getBookType() + " - " + book.getTitle() + " to inventory");
    }

    /**
     * Remove and return outdated books that passed specific number of years
     */
    public List<Book> removeOutdatedBooks(Year thresholdYear) {
        List<Book> outdatedBooks = new ArrayList<>();

        INVENTORY.removeIf(book -> {
            if (book.getYear().isBefore(thresholdYear)) {
                outdatedBooks.add(book);
                System.out.println("Quantum book store: Removed outdated book - " + book.getTitle() +
                        " (Published: " + book.getYear() + ")");
                return true;
            }
            return false;
        });

        return outdatedBooks;
    }


    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = findBookByIsbn(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Book with ISBN " + isbn + " not found in inventory");
        }

        if (!book.isAvailableForPurchase()) {
            throw new IllegalArgumentException("Quantum book store: Book " + book.getTitle() + " is not available for purchase");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantum book store: Quantity must be positive");
        }

        // Process the purchase
        book.processPurchase(quantity, email, address);

        double totalAmount = book.getPrice() * quantity;
        System.out.println("Quantum book store: Purchase successful! Total amount: $" +
                         String.format("%.2f", totalAmount));

        return totalAmount;
    }

    /**
     * Find book by ISBN (returns first match)
     */
    private Book findBookByIsbn(String isbn) {
        for (Book book : INVENTORY) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Get book by ISBN
     */
    public Book getBook(String isbn) {
        return findBookByIsbn(isbn);
    }

    /**
     * Get all books with specific ISBN
     */
    public List<Book> getBooksByIsbn(String isbn) {
        List<Book> books = new ArrayList<>();
        for (Book book : INVENTORY) {
            if (book.getIsbn().equals(isbn)) {
                books.add(book);
            }
        }
        return books;
    }

    /**
     * Get all books in inventory
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(INVENTORY);
    }

    /**
     * Get books by type
     */
    public List<Book> getBooksByType(Class<? extends Book> bookType) {
        List<Book> books = new ArrayList<>();
        for (Book book : INVENTORY) {
            if (bookType.isInstance(book)) {
                books.add(book);
            }
        }
        return books;
    }

    /**
     * Remove a specific book from inventory
     */
    public boolean removeBook(Book book) {
        boolean removed = INVENTORY.remove(book);
        if (removed) {
            System.out.println("Quantum book store: Removed " + book.getTitle() + " from inventory");
        }
        return removed;
    }

    /**
     * Get inventory size
     */
    public int getInventorySize() {
        return INVENTORY.size();
    }

    /**
     * Display inventory
     */
    public void displayInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        System.out.println("====================================");

        if (INVENTORY.isEmpty()) {
            System.out.println("Quantum book store: No books in inventory");
            return;
        }

        for (Book book : INVENTORY) {
            System.out.println("Quantum book store: " + book);
        }
    }

    /**
     * Display inventory grouped by type
     */
    public void displayInventoryByType() {
        System.out.println("Quantum book store: Current Inventory by Type:");
        System.out.println("=============================================");

        if (INVENTORY.isEmpty()) {
            System.out.println("Quantum book store: No books in inventory");
            return;
        }

        Map<String, List<Book>> groupedBooks = new HashMap<>();
        for (Book book : INVENTORY) {
            String type = book.getBookType();
            groupedBooks.computeIfAbsent(type, k -> new ArrayList<>()).add(book);
        }

        for (Map.Entry<String, List<Book>> entry : groupedBooks.entrySet()) {
            System.out.println("Quantum book store: " + entry.getKey() + "s:");
            for (Book book : entry.getValue()) {
                System.out.println("  - " + book);
            }
            System.out.println();
        }
    }
}
