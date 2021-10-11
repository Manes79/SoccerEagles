package pl.manes.soccereagles.handlersManager;

import lombok.SneakyThrows;
import pl.manes.soccereagles.QuitSoccerEaglesAppException;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

public class QuitManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "quit";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @SneakyThrows
    @Override
    public void interceptionsManager(MasterManagerCommand command) {
        throw new QuitSoccerEaglesAppException();

    }
}



