package POO_Collection_Optional.Exercise10.store;

public class Product {

    private String name;
    private String description;
    private double price;
    private int inStockQuantity;

    public Product(String name, String description, double price, int inStockQuantity) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.inStockQuantity = inStockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
