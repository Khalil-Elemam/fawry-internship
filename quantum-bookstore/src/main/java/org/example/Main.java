package org.example;

import java.time.Year;

public class Main {


    public static void main(String[] args) {


        System.out.println("Quantum book store: Welcome to the Quantum Bookstore System!");
        System.out.println("===========================================================");

        BookStore bookstore = new BookStore();

        // Test 1: Adding different types of books
        System.out.println("\nQuantum book store: Adding sample books to inventory...");

        bookstore.addBook(new PaperBook("PB001", "Java Programming Guide", Year.of(2023), 45.99, 15));
        bookstore.addBook(new PaperBook("PB002", "Data Structures", Year.of(2020), 39.99, 5));
        bookstore.addBook(new EBook("EB001", "Web Development Essentials", Year.of(2024), 29.99, "PDF"));
        bookstore.addBook(new EBook("EB002", "Machine Learning", Year.of(2021), 34.99, "EPUB"));
        bookstore.addBook(new ShowcaseBook("SB001", "Quantum Computing Theory", Year.of(2024), 99.99));
        bookstore.addBook(new ShowcaseBook("SB002", "AI Ethics", Year.of(2023), 49.99));

        bookstore.displayInventory();



        // Test 2: Demonstrate purchases
        System.out.println("\nQuantum book store: Demonstrating book purchases...");
        try {
            double amount1 = bookstore.buyBook("PB001", 2, "customer@example.com", "123 Main Street, City");
            System.out.println("Quantum book store: Payment processed: $" + String.format("%.2f", amount1));

            double amount2 = bookstore.buyBook("EB001", 1, "customer@example.com", "123 Main Street, City");
            System.out.println("Quantum book store: Payment processed: $" + String.format("%.2f", amount2));
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }



        // Test 3: Error handling
        System.out.println("\nQuantum book store: Testing error handling...");

        try {
            // Try to buy showcase book (should fail)
            bookstore.buyBook("SB001", 1, "customer@example.com", "123 Main Street, City");
        } catch (Exception e) {
            System.out.println("Quantum book store: Expected error - " + e.getMessage());
        }

        try {
            // Try to buy non-existent book
            bookstore.buyBook("INVALID", 1, "customer@example.com", "123 Main Street, City");
        } catch (Exception e) {
            System.out.println("Quantum book store: Expected error - " + e.getMessage());
        }

        try {
            // Try to buy more than available stock
            bookstore.buyBook("PB002", 10, "customer@example.com", "123 Main Street, City");
        } catch (Exception e) {
            System.out.println("Quantum book store: Expected error - " + e.getMessage());
        }



        // Test 4: Remove outdated books
        System.out.println("\nQuantum book store: Testing outdated books removal...");

        // Add an old book for testing
        bookstore.addBook(new PaperBook("OLD001", "Legacy Programming", Year.of(2010), 25.99, 3));

        // Remove books published before 2015
        var outdatedBooks = bookstore.removeOutdatedBooks(Year.of(2015));
        System.out.println("Quantum book store: Found " + outdatedBooks.size() + " outdated books");

        // Final inventory display
        System.out.println("\nQuantum book store: Final inventory state:");
        bookstore.displayInventory();

        System.out.println("\nQuantum book store: Demo completed successfully!");
    }
}