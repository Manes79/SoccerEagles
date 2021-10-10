package pl.manes.soccereagles.handlersUser;

abstract class BasicCommandUserHandler implements MasterUserHandler {

    @Override
    public boolean helpInterceptionUser(String name) {
        return getCommandName().equals(name);
    }

    protected abstract Object getCommandName();
}
