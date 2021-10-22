package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.QuitSoccerEaglesAppException;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

public class QuitUserHandler extends BasicCommandUserHandler {

    private static final String COMMAND_NAME = "quit";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) {

        throw new QuitSoccerEaglesAppException();
    }
}
