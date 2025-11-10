package Exercise9.productManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StockManager {

    private List<Product> products;

    public StockManager(List<Product> products) {
        this.products = new ArrayList<Product>(products);
    }

    public void addProduct(Product product) {

        products.add(product);
    }

    public Optional<Product>  findProductById(int id) {

        return products.stream().filter(product -> Objects.nonNull(product) && Objects.equals(product.getId(), id)).findFirst();
    }


    public Optional<Product> findTheCheaperProduct() {

        return  products.stream().filter(Objects::nonNull).reduce((product1, product2) ->  product1.getPrice() <= product2.getPrice() ? product1 : product2);
    }
}