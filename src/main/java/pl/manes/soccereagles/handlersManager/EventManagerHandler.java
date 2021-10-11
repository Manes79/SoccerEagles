package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.daoManager.EventManagerDao;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.structureManager.EventManager;

import java.util.List;

public class EventManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "event";

    private final EventManagerDao eventManagerDao;

    public EventManagerHandler() {

        eventManagerDao = new EventManagerDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {

        switch (command.getAction()) {

            case "add":
                System.out.println("A new event has been added");
                String event = command.getTypedCommand().get(0);
                eventManagerDao.addAll(new EventManager(event));
                break;

            case "list":
                System.out.println("List of events");
                    List<EventManager> eventManager = eventManagerDao.findAllEventManagerCategories();
                    eventManager.forEach(System.out::println);
                    break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));

            }
        }
    }
}
