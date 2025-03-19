package org.Exercise7;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int quantity;


    public Product(int id, String name, int quantity){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId() && getQuantity() == product.getQuantity() && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, getQuantity());
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity ;
    }
}
