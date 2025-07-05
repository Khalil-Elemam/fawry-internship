package org.example;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.nCopies;

public class CheckoutService {
    private final ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new RuntimeException("Cart is empty.");

        double subtotal = cart.getSubtotal();

        List<Shippable> toShip = cart.getItems().stream()
                .filter(ci -> ci.getProduct() instanceof Shippable)
                .flatMap(ci -> {
                    Shippable shippable = (Shippable) ci.getProduct();
                    return nCopies(ci.getQuantity(), shippable).stream();
                }).collect(Collectors.toList());

        double shippingFee = shippingService.calculateShippingFee(toShip);
        double total = subtotal + shippingFee;
        if (customer.getBalance() < total)
            throw new RuntimeException("Insufficient balance.");

        shippingService.processShipment(toShip);

        // Deduct stock and balance
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            p.setQuantity(p.getQuantity() - item.getQuantity());
        }
        customer.setBalance(customer.getBalance() - total);


        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f%n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("\n" + "-".repeat(25));
        System.out.printf("Subtotal         %.0f%n", subtotal);
        System.out.printf("Shipping         %.0f%n", shippingFee);
        System.out.printf("Amount           %.0f%n", total);
        System.out.printf("Balance left     %.0f%n", customer.getBalance());
    }
}
