package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

public class HelpManagerHandler extends BasicCommandManagerHandler {

    public static final String COMMAND_NAME = "help";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {
        super.interceptionsManager(command);

        Object action = command.getAction();

        if ("help".equals(action)) {
            System.out.println("Available commands:");
        } else if ("quit".equals(action)) {
            System.out.println("Closing the app");
        }

        System.out.println("Allowed commands: help, quite, category, question, answer");
        System.out.println("Command pattern: <command> <action> <parameters1> <parameters2>");
        System.out.println("Example: category add CategoryName");

    }
}
