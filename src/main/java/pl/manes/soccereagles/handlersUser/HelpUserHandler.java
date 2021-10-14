package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

public class HelpUserHandler extends BasicCommandUserHandler {

    private static final String COMMAND_NAME = "help";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) {

        Object action = command.getAction();

        if ("help".equals(action)) {
            System.out.println("Available commands: help, add, list, confirm, declined, event, changeDecision, eventStatus");
        } else if ("add".equals(action)) {
            System.out.println("Add some category");
        } else if ("list".equals(action)) {
            System.out.println("Displaying confirmation, rejection and change of the User's decision and event status");
        } else
            throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));

    }
}
