package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.io.IOException;

public interface MasterUserHandler {

    void interceptionUser(MasterUserCommand command) throws IOException;

    boolean helpInterceptionUser(String name);
}
