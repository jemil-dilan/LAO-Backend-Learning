package POO_COLL_OPT.Exercise7.commandManager;

import java.util.*;

public class CommandsService {

    Set<Command> commands;

    public CommandsService(Set<Command> commands) {
        this.commands = new HashSet<>(commands);
    }

    public void addCommand(Command command){

        commands.add(command);
    }

    public void removeCommand(Command command){

        commands.remove(command);
    }


    public Optional<Command> mostExpensiveCommand(){

        return  commands.stream()
                .filter(Objects::nonNull)
                .peek(Command::calculateCost)
                .reduce((command1, command2) ->  command1.getCost() >= command2.getCost() ? command1 : command2);
    }
}
