package org.example;

import java.util.Objects;

public class Customer {

    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return Double.compare(balance, customer.balance) == 0 && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }
}
