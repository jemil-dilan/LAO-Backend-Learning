package orders;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Order> orders = new ArrayList<Order>();

    public Customer(List<Order> orders) {
        this.orders = orders;
    }

    public void allOrders(){

        System.out.println("Mes commandes:");
        for (Order order : orders) {

            System.out.println("N° " + order.getCommandNumber() + "Articles: "
            + order.getMenuItems() + "Total: "
            + order.getTotalPrice());
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}

