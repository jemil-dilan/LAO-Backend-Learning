package POO.Exercice7.basket;

public class Product {
    
    private String id;
    private String name;
    private int price;
    private int quantity;

    public Product(String id, String name, int price, int quantity){

        this.id = id;
        this.name = name;
        this.price = Math.max(0, price);
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public String getName() {
        return name;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
