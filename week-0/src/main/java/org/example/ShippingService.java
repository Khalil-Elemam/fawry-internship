package org.example;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;


public class ShippingService {
    private static final double SHIPPING_RATE_PER_KG = 30.0; // $30 per kg
    private static final double KG_CONVERSION = 1000.0;

    public double calculateShippingFee(List<Shippable> items) {
        if (items == null || items.isEmpty()) {
            return 0.0;
        }

        double totalWeight = items.stream()
                                 .mapToDouble(Shippable::getWeight)
                                 .sum();

        double weightInKg = totalWeight / KG_CONVERSION;
        return Math.ceil(weightInKg) * SHIPPING_RATE_PER_KG;
    }

    public void processShipment(List<Shippable> items) {
        if (items == null || items.isEmpty()) {
            return;
        }
        System.out.println(items);
        System.out.println("** Shipment notice **");

        Map<String, Integer> itemCounts = new LinkedHashMap<>();
        Map<String, Double> itemWeights = new LinkedHashMap<>();

        for (Shippable item : items) {
            String name = item.getName();
            itemCounts.put(name, itemCounts.getOrDefault(name, 0) + 1);
            itemWeights.put(name, item.getWeight());
        }
        
        double totalWeight = 0.0;
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String name = entry.getKey();
            int quantity = entry.getValue();
            double weight = itemWeights.get(name);
            
            System.out.printf("%dx %-12s %dg%n", quantity, name, (int)weight * quantity);
            totalWeight += weight * quantity;
        }
        
        System.out.printf("Total package weight %.1fkg%n \n", totalWeight / KG_CONVERSION);
    }
}
