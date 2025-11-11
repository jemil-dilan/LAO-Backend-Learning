package POO.Exercice9.orders;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private Set<Order> orders = new HashSet<Order>();

    public Customer(Set<Order> orders) {
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

    public  void placeAnOrder(Restaurant restaurant, Set<MenuItem> menuItems) {

        var commandNumber =  orders.size() + 1;

        Order order = new Order();
        order.setMenuItems(menuItems);
        order.setCommandNumber(commandNumber);
        order.calculatePrice();

        this.orders.add(order);
        restaurant.getOrders().add(order);
    }

    public Set<Order> getOrders() {
        return orders;
    }
}

