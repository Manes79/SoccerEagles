package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.util.logging.Logger;

public class HelpManagerHandler extends BasicCommandManagerHandler {

    private static final Logger LOG = Logger.getLogger(HelpManagerHandler.COMMAND_NAME);

    private static final String COMMAND_NAME = "help";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {

        Object action = command.getAction();

        if (ActionManager.HELP.equals(action)) {
            LOG.info("Available command: event, dateEvent, statusConfirmed, statusDeclined, decision, infoForUsers, question fromUsers, randomPlayer, resetEvent");
        } else if (ActionManager.ADD.equals(action)) {
            LOG.info("Add some category");
        } else if (ActionManager.LIST.equals(action)) {
            LOG.info("Displays a list of added events, decisions about events and questions from Users");
        } else
            throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
    }
}
