package Exercise7.commandManager;

import java.util.ArrayList;
import java.util.List;

public class Command {

    private int commandNumber;
    private List<Item> orderedItems;
    private Costumer costumer;
    private int cost;

    public Command(int commandNumber, List<Item> orderedItems) {
        this.commandNumber = commandNumber;
        this.orderedItems = new ArrayList<Item>(orderedItems);
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public List<Item> getOrderedItems() {
        return orderedItems;
    }

    public void calculateCost(){

        setCost(orderedItems.stream().mapToInt(Item::getPrice).sum());
    }
}
