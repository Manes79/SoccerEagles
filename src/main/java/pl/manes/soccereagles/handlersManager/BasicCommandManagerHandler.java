package pl.manes.soccereagles.handlersManager;

abstract class BasicCommandManagerHandler implements MasterManagerHandler {

    @Override
    public boolean helpInterceptionManager(String name) {
        return getCommandName().equals(name);
    }

    protected abstract Object getCommandName();
}
