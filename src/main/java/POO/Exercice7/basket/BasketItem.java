public class BasketItem {
    
    private Product product;
    private int quantity;

    public BasketItem(Product product, int quantity){

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduit() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
