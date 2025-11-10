package Exercise4.productCatalog;

public class Product {

    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product info :" +
                "id=" + id +
                ", name='" + name +
                ", price=" + price ;
    }
}