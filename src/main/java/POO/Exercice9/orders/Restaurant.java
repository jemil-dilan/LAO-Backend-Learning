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

    public Order createAnOrder(List<String> nomsArticles){

        Order anOrder = new Order();
        Set<MenuItem> commandItem = new LinkedHashSet<MenuItem>();
        int totalPrice = 0;


        for (MenuItem menuItem : menu) {

            for (String string : nomsArticles) {
                
                if (Objects.equals(menuItem.getNom(), string)) {
                    
                    commandItem.add(menuItem);
                }
            }
        }
        
        //Déterminer le prix total
        for (MenuItem articleCommande : commandItem) {

            totalPrice = totalPrice + articleCommande.getPrix();
        }

        //Créer une commande
        anOrder.setMenuItems(commandItem);
        anOrder.setTotalPrice(totalPrice);
        anOrder.setCommandNumber(this.orders.getLast().getCommandNumber() + 1);
        return anOrder;
    }

    public int calculateTotalOfSales(){

        System.out.println("Total de la Facture");

        int total = 0;
        for (Order order : orders) {
            
            total = total + order.getTotalPrice();
        }
        return total;
    }
}
