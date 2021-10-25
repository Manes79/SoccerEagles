package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

public class HelpManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "help";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {

        Object action = command.getAction();

        if ("help".equals(action)) {
            System.out.println("Available command: event, dateEvent, statusConfirmed, statusDeclined, decision, infoForUsers, question fromUsers, randomPlayer, resetEvent");
        } else if ("add".equals(action)) {
            System.out.println("Add some category");
        } else if ("list".equals(action)) {
            System.out.println("Displays a list of added events, decisions about events and questions from Users");
        } else
            throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
    }
}
