package POO_COLL_OPT.Exercise7.commandManager;

import java.util.*;

public class CommandsService {

    Set<Command> commandsCosts;

    public CommandsService(Set<Command> commandsCosts) {
        this.commandsCosts = commandsCosts;
    }

    public void addCommand(Command command){

        commandsCosts.add(command);
    }

    public void removeCommand(Command command){

        commandsCosts.remove(command);
    }


    public Optional<Command> mostExpensiveCommand(){

        return  commandsCosts.stream()
                .filter(Objects::nonNull)
                .peek(Command::calculateCost)
                .reduce((commandCost1, commandCost2) -> commandCost1.getCost() >= commandCost2.getCost() ? commandCost1: commandCost2);
    }
}
