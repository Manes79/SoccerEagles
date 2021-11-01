package pl.manes.soccereagles.handlersmanager;

import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public interface MasterManagerHandler {

    void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException, MalformedURLException;

    boolean helpInterceptionManager(String name);

}
