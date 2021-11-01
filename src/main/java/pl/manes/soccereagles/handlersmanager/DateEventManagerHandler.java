package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.daomanager.DateEventManagerDao;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;
import pl.manes.soccereagles.structuremanager.DateEventManager;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class DateEventManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "dateEvent";
    private final DateEventManagerDao dateEventManagerDao;

    public DateEventManagerHandler() {

        dateEventManagerDao = new DateEventManagerDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {

        switch (command.getAction()) {

            case ADD:
                String eventDate = command.getTypedCommand().get(0);
                dateEventManagerDao.addAll(new DateEventManager(eventDate));
                log.info("A new data for event has been added ");
                break;

            case LIST:
                List<DateEventManager> dateEventManagers = dateEventManagerDao.findAllDataEventManagerCategories();
                dateEventManagers.forEach(System.out::println);
                break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}