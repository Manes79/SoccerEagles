package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.io.FileNotFoundException;

public interface MasterUserHandler {

    void interceptionUser(MasterUserCommand command) throws FileNotFoundException;

    boolean helpInterceptionUser(String name);
}
