package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.io.FileNotFoundException;

public interface MasterManagerHandler {

    void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException;

    boolean helpInterceptionManager(String name);

}
