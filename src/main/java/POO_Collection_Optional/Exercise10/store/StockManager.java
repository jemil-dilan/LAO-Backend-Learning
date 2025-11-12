package POO_Collection_Optional.Exercise10.store;


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

    public String getProductDescription(Product product){

        Optional<String> productDescription = Optional.ofNullable(product.getDescription());
        return productDescription.orElse("Description unspecified");
    }

    public Optional<Product> findTheCheaperProduct() {

        return  products.stream().filter(Objects::nonNull).reduce((product1, product2) ->  product1.getPrice() <= product2.getPrice() ? product1 : product2);
    }
}