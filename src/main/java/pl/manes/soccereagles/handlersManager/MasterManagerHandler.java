package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

public interface MasterManagerHandler {

    void interceptionsManager(MasterManagerCommand command);

    boolean helpInterceptionManager(String name);

}
