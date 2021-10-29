package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.ActionUser;
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

        if (ActionUser.HELP.equals(action)) {
            System.out.println("Available commands: add, list, confirm, declined, event, eventStatus, infoFromManager, announcement, questionTo");
        } else if (ActionUser.ADD.equals(action)) {
            System.out.println("Add some category");
        } else if (ActionUser.LIST.equals(action)) {
            System.out.println("Displaying confirmations and rejections of the User's decision, event status and information from Event Manager");
        } else
            throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
    }
}
