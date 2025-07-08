package org.example;

public class ShippingService {


    public static void ship(PaperBook book, int quantity, String address) {
        System.out.printf("""
                Quantum book store: Shipping %d copy(ies) of '%s' to address: %s
                %n""", quantity, book.getTitle(), address
        );
    }


}
