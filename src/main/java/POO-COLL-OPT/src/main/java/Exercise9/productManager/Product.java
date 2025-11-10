package Exercise9.productManager;

public class Product {

    private int id;
    private String name;
    private int price;
    private int stock;

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product info :" +
                "id=" + id +
                ", name='" + name +
                ", price=" + price +
                ", stock=" + stock ;
    }
}