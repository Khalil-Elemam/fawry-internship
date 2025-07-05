package org.example;


import java.time.LocalDate;


public class Main {


    public static void main(String[] args) {

        Product cheese = new ShippableProduct("Cheese", 100, 10, LocalDate.now().plusDays(5), 200);
        Product biscuits = new ShippableProduct("Biscuits", 150, 5, LocalDate.now().plusDays(1), 700);
        Product tv = new ShippableProduct("TV", 1000, 2, null, 8000); // non expiring product
        Product scratchCard = new Product("Scratch Card", 50, 20, null);

        Customer customer = new Customer("Khalil", 1000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService checkoutService = new CheckoutService(new ShippingService());
        checkoutService.checkout(customer, cart);

    }


}