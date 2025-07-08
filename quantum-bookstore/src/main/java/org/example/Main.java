package org.example;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        System.out.println("Quantum book store: Welcome to the Quantum Bookstore System!");
        System.out.println("===========================================================");

        // Create bookstore instance
        BookStore bookstore = new BookStore();

        // Add sample books
        System.out.println("\nQuantum book store: Adding sample books to inventory...");

        bookstore.addBook(new PaperBook("PB001", "Java Programming Guide", Year.of(2023), 45.99, 15));
        bookstore.addBook(new EBook("EB001", "Web Development Essentials", Year.of(2024), 29.99, "PDF"));
        bookstore.addBook(new ShowcaseBook("SB001", "Quantum Computing Theory", Year.of(2024), 99.99));

        // Display inventory
        bookstore.displayInventory();

        // Demonstrate purchases
        System.out.println("\nQuantum book store: Demonstrating book purchases...");
        try {
            bookstore.buyBook("PB001", 2, "customer@example.com", "123 Main Street, City");
            bookstore.buyBook("EB001", 1, "customer@example.com", "123 Main Street, City");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        System.out.println("\nQuantum book store: Demo completed!");
    }
}