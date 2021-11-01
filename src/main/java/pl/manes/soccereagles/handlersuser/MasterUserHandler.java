package pl.manes.soccereagles.handlersuser;

import pl.manes.soccereagles.inputuser.MasterUserCommand;

import java.io.IOException;

public interface MasterUserHandler {

    void interceptionUser(MasterUserCommand command) throws IOException;

    boolean helpInterceptionUser(String name);
}
