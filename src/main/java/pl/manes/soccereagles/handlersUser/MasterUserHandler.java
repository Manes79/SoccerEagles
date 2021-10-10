package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

public interface MasterUserHandler {

    default void interceptionUser(MasterUserCommand command) {

    }

    boolean helpInterceptionUser(String name);
}
