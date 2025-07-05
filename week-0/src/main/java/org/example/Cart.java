package org.example;


import java.util.ArrayList;
import java.util.List;




public class Cart {
    private final List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity)  {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (quantity > product.getQuantity()) {
            throw new RuntimeException("Cannot add " + quantity + " items. Only " + product.getQuantity() + " available.");
        }

        if (product.isExpired()) {
            throw new RuntimeException("Cannot add expired product: " + product.getName());
        }


        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity > product.getQuantity()) {
                    throw new RuntimeException("Cannot add " + quantity + " more items. Only " +
                            (product.getQuantity() - item.getQuantity()) + " more available.");
                }
                item.setQuantity(newQuantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream()
                   .mapToDouble(CartItem::getTotalPrice)
                   .sum();
    }

    public void clear() {
        items.clear();
    }

}


