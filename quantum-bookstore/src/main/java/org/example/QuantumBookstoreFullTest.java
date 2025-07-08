package org.example;

import java.time.Year;

public class QuantumBookstoreFullTest {

    public static void main(String[] args) {
        System.out.println("Quantum book store: Starting Full Test Suite");
        System.out.println("==============================================");

        // Create bookstore instance
        BookStore bookstore = new BookStore();

        // Test 1: Adding different types of books
        System.out.println("\nQuantum book store: TEST 1 - Adding Books to Inventory");
        System.out.println("----------------------------------------------------");

        // Add Paper Books
        PaperBook paperBook1 = new PaperBook("PB001", "Java Programming", Year.of(2022), 45.99, 10);
        PaperBook paperBook2 = new PaperBook("PB002", "Data Structures", Year.of(2020), 39.99, 5);

        // Add E-Books
        EBook eBook1 = new EBook("EB001", "Advanced Java", Year.of(2023), 29.99, "PDF");
        EBook eBook2 = new EBook("EB002", "Machine Learning", Year.of(2021), 34.99, "EPUB");

        // Add Showcase Books
        ShowcaseBook showcaseBook1 = new ShowcaseBook("SB001", "Quantum Computing", Year.of(2024), 59.99);
        ShowcaseBook showcaseBook2 = new ShowcaseBook("SB002", "AI Ethics", Year.of(2023), 49.99);

        bookstore.addBook(paperBook1);
        bookstore.addBook(paperBook2);
        bookstore.addBook(eBook1);
        bookstore.addBook(eBook2);
        bookstore.addBook(showcaseBook1);
        bookstore.addBook(showcaseBook2);

        bookstore.displayInventory();

        // Test 2: Buying Books
        System.out.println("\nQuantum book store: TEST 2 - Buying Books");
        System.out.println("----------------------------------------");

        try {
            // Buy Paper Book
            double amount1 = bookstore.buyBook("PB001", 2, "customer@email.com", "123 Main St, City");
            System.out.println("Quantum book store: Payment processed: $" + String.format("%.2f", amount1));

            // Buy E-Book
            double amount2 = bookstore.buyBook("EB001", 1, "customer@email.com", "123 Main St, City");
            System.out.println("Quantum book store: Payment processed: $" + String.format("%.2f", amount2));

        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        // Test 3: Error Cases
        System.out.println("\nQuantum book store: TEST 3 - Error Handling");
        System.out.println("------------------------------------------");

        try {
            // Try to buy showcase book (should fail)
            bookstore.buyBook("SB001", 1, "customer@email.com", "123 Main St, City");
        } catch (Exception e) {
            System.out.println("Quantum book store: Expected error - " + e.getMessage());
        }

        try {
            // Try to buy non-existent book
            bookstore.buyBook("INVALID", 1, "customer@email.com", "123 Main St, City");
        } catch (Exception e) {
            System.out.println("Quantum book store: Expected error - " + e.getMessage());
        }

        try {
            // Try to buy more than available stock
            bookstore.buyBook("PB002", 10, "customer@email.com", "123 Main St, City");
        } catch (Exception e) {
            System.out.println("Quantum book store: Expected error - " + e.getMessage());
        }

        // Test 4: Removing outdated books
        System.out.println("\nQuantum book store: TEST 4 - Removing Outdated Books");
        System.out.println("---------------------------------------------------");

        // Add an old book for testing
        PaperBook oldBook = new PaperBook("OLD001", "Legacy Programming", Year.of(2010), 25.99, 3);
        bookstore.addBook(oldBook);

        // Remove books older than 2015 (published before 2015)
        var outdatedBooks = bookstore.removeOutdatedBooks(Year.of(2015));
        System.out.println("Quantum book store: Found " + outdatedBooks.size() + " outdated books");

        // Test 5: Final inventory display
        System.out.println("\nQuantum book store: TEST 5 - Final Inventory State");
        System.out.println("------------------------------------------------");
        bookstore.displayInventory();

        System.out.println("\nQuantum book store: Full Test Suite Completed Successfully!");
    }
}
