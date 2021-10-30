package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.util.logging.Logger;

public class HelpUserHandler extends BasicCommandUserHandler {

    private static final Logger LOG = Logger.getLogger(HelpUserHandler.COMMAND_NAME);

    private static final String COMMAND_NAME = "help";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) {

        Object action = command.getAction();

        if (ActionUser.HELP.equals(action)) {
            LOG.info("Available commands: add, list, confirm, declined, event, eventStatus, infoFromManager, announcement, questionTo");
        } else if (ActionUser.ADD.equals(action)) {
            LOG.info("Add some category");
        } else if (ActionUser.LIST.equals(action)) {
            LOG.info("Displaying confirmations and rejections of the User's decision, event status and information from Event Manager");
        } else
            throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
    }
}
