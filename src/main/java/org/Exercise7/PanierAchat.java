package org.Exercise7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PanierAchat {
    List<Product> products;
    public PanierAchat(){
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void deleteProduct(int id){
        products.removeIf(product -> product.getId() == id);
    }

    public int productsQuantity(){
        int totalQuantity = 0;
        for(Product product : products){
            totalQuantity =+ product.getQuantity();
        }
        return totalQuantity;
    }
}
