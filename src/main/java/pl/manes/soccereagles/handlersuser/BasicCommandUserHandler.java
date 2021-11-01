package pl.manes.soccereagles.handlersuser;

abstract class BasicCommandUserHandler implements MasterUserHandler {

    @Override
    public boolean helpInterceptionUser(String name) {
        return getCommandName().equals(name);
    }

    protected abstract String getCommandName();
}
