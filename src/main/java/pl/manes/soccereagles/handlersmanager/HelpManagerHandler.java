package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class HelpManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "help";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {

        Object action = command.getAction();

        if (ActionManager.HELP.equals(action)) {
            System.out.println("Available command: event, dateEvent, statusConfirmed, statusDeclined, decision, infoForUsers, question fromUsers, randomPlayer, resetEvent");
        } else if (ActionManager.ADD.equals(action)) {
            System.out.println("Add some category");
        } else if (ActionManager.LIST.equals(action)) {
            System.out.println("Displays a list of added events, decisions about events and questions from Users");
        } else
            throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
    }
}
