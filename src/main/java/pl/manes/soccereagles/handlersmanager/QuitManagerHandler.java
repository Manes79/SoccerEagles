package pl.manes.soccereagles.handlersmanager;

import lombok.SneakyThrows;
import pl.manes.soccereagles.QuitSoccerEaglesAppException;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

public class QuitManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "quit";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @SneakyThrows
    @Override
    public void interceptionsManager(MasterManagerCommand command) {
        throw new QuitSoccerEaglesAppException();

    }
}



