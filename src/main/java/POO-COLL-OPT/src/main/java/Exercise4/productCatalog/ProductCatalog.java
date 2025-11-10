package Exercise4.productCatalog;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.List;

public class ProductCatalog {

    private List<Product> products;

    public ProductCatalog(List<Product> products) {
        this.products = new ArrayList<Product>(products);
    }

    public void addProduct(Product product) {

        products.add(product);
    }

    public void displayProduct(){

        products.forEach(System.out::println);
    }

    public Optional<Product>  findProductById(int id) {

        return products.stream().filter(product -> Objects.nonNull(product) && Objects.equals(product.getId(), id)).findFirst();
    }
}