package pl.manes.soccereagles.handlersuser;

import pl.manes.soccereagles.QuitSoccerEaglesAppException;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

public class QuitUserHandler extends BasicCommandUserHandler {

    private static final String COMMAND_NAME = "quit";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) {

        throw new QuitSoccerEaglesAppException();
    }
}
