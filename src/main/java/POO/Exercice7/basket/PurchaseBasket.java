import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PurchaseBasket {
    
    private List<BasketItem> listeBasketItems = new ArrayList<BasketItem>();

    public void addItem(Product product, int quantity){

        BasketItem basketItem = new BasketItem(product, quantity);
        listeBasketItems.add(basketItem);
    }

    public void removeItem(String idProduit){

        for (BasketItem basketItem : listeBasketItems) {
            
            if (Objects.equals(basketItem.getProduct().getId(), idProduit)) {
                
                listeBasketItems.remove(basketItem);
            }
        }
    }

    public void updateQuantity(String idProduit, int newQuantity){
        
        for (BasketItem basketItem : listeBasketItems) {
            
            if (Objects.equals(basketItem.getProduct().getId(), idProduit)) {
                
                basketItem.getProduct().setQuantity(newQuantity);
            }
        }
    }

    public int calculateTotal(){

        int total=0;
        for (BasketItem basketItem : listeBasketItems) {

            total = basketItem.getQuantity() * basketItem.getProduct().getPrice();
        }
        return total;
    }

    public void applyDiscount(double percentage){

        System.out.println("Application d'une remise de " + percentage + "%");
        System.out.println("Total à payer: " + (calculateTotal() - percentage * calculateTotal())); ;
    }

    public void validate(){
        
        System.out.println("Inventaire des commmandes");
        System.out.println("Produit: " + "----|----" + "prix_u: " + "----|----" + "Total: " + "--------|");
        for (BasketItem basketItem : listeBasketItems) {

            System.out.println(basketItem.getProduct().getName() + "         "
            + basketItem.getProduct().getPrice() + "         "
            + (basketItem.getProduct().getPrice() * basketItem.getQuantity()));
        }
        
        System.out.println("                          Total                     " + this.calculateTotal());
    }

}
