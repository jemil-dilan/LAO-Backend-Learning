package Exercise7.commandManager;

import java.util.HashSet;
import java.util.Set;

public class Costumer {

    private String name;
    private int tel;
    private Set<Command> orders;

    public Costumer(String name, int tel, Set<Command> orders) {
        this.name = name;
        this.tel = tel;
        this.orders = new HashSet<Command>(orders);
    }

}
