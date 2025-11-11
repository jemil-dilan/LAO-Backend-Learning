package POO_Collection_Optional.Exercise5.portfolio;

import java.util.Optional;

public class Investment {

    private final String name;
    private final int quantity;
    private double price;

    public Investment(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }

    public Optional<Double> getTotalValue() {
        return Optional.ofNullable(price).map(p -> p * quantity);
    }

    @Override
    public String toString() {

        return "Investment{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + Optional.ofNullable(price).orElse(0.0) +
                '}';
    }
}

