package orders;

import java.util.LinkedHashSet;
import java.util.Set;

public class Order {
    
    private Set<MenuItem> menuItems = new LinkedHashSet<MenuItem>();
    private int commandNumber;
    private int totalPrice;

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
