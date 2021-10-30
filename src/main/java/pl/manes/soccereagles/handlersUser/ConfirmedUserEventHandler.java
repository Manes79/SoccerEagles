package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.daoUser.ConfirmedUserEventDao;
import pl.manes.soccereagles.inputUser.MasterUserCommand;
import pl.manes.soccereagles.structureUser.ConfirmedEvent;

import java.util.List;
import java.util.logging.Logger;

public class ConfirmedUserEventHandler extends BasicCommandUserHandler {

    private final static Logger LOG = Logger.getLogger(ConfirmedUserEventHandler.COMMAND_NAME);

    private final static String COMMAND_NAME = "confirm";

    private final ConfirmedUserEventDao confirmedUserEventDao;

    public ConfirmedUserEventHandler() {

        confirmedUserEventDao = new ConfirmedUserEventDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) {

        switch (command.getAction()) {

            case ADD:
                LOG.info("A new user has been added to event");
                String confirmingName = command.getTypedCommand().get(0);
                confirmedUserEventDao.addAll(new ConfirmedEvent(confirmingName));
                break;

            case LIST:
                LOG.info("List of confirmed Users");
                List<ConfirmedEvent> confirmedEvent = confirmedUserEventDao.findAllConfirmedEventCategories();
                confirmedEvent.forEach(System.out::println);
                break;

            default:
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
        }
    }
}