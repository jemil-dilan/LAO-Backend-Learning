package POO.Exercice9.orders;

import java.util.LinkedHashSet;
import java.util.Set;

public class Order {
    
    private Set<MenuItem> menuItems = new LinkedHashSet<MenuItem>();
    private int commandNumber;
    private int totalPrice;

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(int commandNumber) {
        this.commandNumber = commandNumber;
    }
    
    public int getTotalPrice() {
        return totalPrice;
    }

    public void calculatePrice(){

        for (MenuItem menuItem : menuItems) {

            totalPrice += menuItem.getPrice();
        }
    }
}
