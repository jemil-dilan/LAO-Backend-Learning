package orders;

import java.util.*;

public class Restaurant {
    
    private Set<MenuItem> menu = new LinkedHashSet<MenuItem>();
    private List<Order> orders = new ArrayList<Order>();

    public void addMenuItem(MenuItem article){

        menu.add(article);
    }

    public void displayMenu(){

        System.out.println("        MENU        ");
        
        Iterator<MenuItem> iterator = menu.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public Order createAnOrder(List<String> itemsNames){


        Set<MenuItem> commandItem = new LinkedHashSet<MenuItem>();

        for (MenuItem menuItem : menu) {

            for (String itemName : itemsNames) {

                if (Objects.equals(menuItem.getName(), itemName)) {
                    
                    commandItem.add(menuItem);
                }
            }
        }

        Order order = new Order();
        order.setMenuItems(commandItem);
        order.calculatePrice();
        order.setCommandNumber(this.orders.getLast().getCommandNumber() + 1);

        return order;
    }

    public int calculateTotalOfSales(){

        System.out.println("Total de la Facture");

        int total = 0;
        for (Order order : orders) {
            
            total = total + order.getTotalPrice();
        }
        return total;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
