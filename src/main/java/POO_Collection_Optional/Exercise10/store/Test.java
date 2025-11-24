package POO_Collection_Optional.Exercise10.store;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static void main(String[] args) {

        Product product1 = new Product("Elena tomato", "Tomate en sachet", 125, 500);
        Product product2 = new Product("Mayor", "Table Oil", 1600, 2554);
        Product product3 = new Product("La pasta", "Spaghetti italien", 500, 867);
        Product product4 = new Product("President", null, 1350, 300);

        List<Product> products = new ArrayList<>();
//        products.add(product2);
//        products.add(product3);
//        products.add(product4);

        StoreManager storeManager = new StoreManager(products);
//        storeManager.addProduct(product1);
//        storeManager.removeProduct(product1);
        storeManager.displayProducts();

        System.out.println("\nThe cheaper product is :" + storeManager.findTheCheaperProduct());
        System.out.println("The description of product 4 is : " + storeManager.getProductDescription(product4));;
    }
}
