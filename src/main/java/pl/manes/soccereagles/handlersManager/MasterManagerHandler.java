package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

public interface MasterManagerHandler {

    default void interceptionsManager(MasterManagerCommand command) {
    }

    boolean helpInterceptionManager(String name);
}
