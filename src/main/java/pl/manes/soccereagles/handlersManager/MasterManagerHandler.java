package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public interface MasterManagerHandler {

    void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException, MalformedURLException;

    boolean helpInterceptionManager(String name);

}
