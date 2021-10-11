package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

public interface MasterUserHandler {

    void interceptionUser(MasterUserCommand command);

    boolean helpInterceptionUser(String name);
}
