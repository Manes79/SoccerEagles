package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.daoManager.DateEventManagerDao;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.structureManager.DateEventManager;

import java.util.List;

public class DateEventManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "dateEvent";

    private final DateEventManagerDao dateEventManagerDao;

    public DateEventManagerHandler() {

        dateEventManagerDao = new DateEventManagerDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {

        switch (command.getAction()) {

            case "add":
                String dateEvent = command.getTypedCommand().get(0);
                dateEventManagerDao.addAll(new DateEventManager(dateEvent));
                System.out.println("A new data for event has been added ");
                break;

            case "list":
                List<DateEventManager> dateEventManagers = dateEventManagerDao.findAllDataEventManagerCategories();
                dateEventManagers.forEach(System.out::println);
                break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}