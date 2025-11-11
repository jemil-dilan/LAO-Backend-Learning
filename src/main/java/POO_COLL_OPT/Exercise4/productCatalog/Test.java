package POO_COLL_OPT.Exercise4.productCatalog;

import java.util.*;

public class Test {

    public static void main(String[] args) {

    List<Product> products = new ArrayList<Product>();
        Product product1 = new Product(1, "tour", 233);
        Product product2 = new Product(2, "bishop", 234);
        Product product3 = null;

        products.add(product2);
        products.add(product1);
        products.add(product3);

        ProductCatalog productCatalog = new ProductCatalog(products);

        System.out.println(productCatalog.findProductById(3));
    }

}
