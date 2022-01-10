package pl.manes.soccereagles.handlersuser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import pl.manes.soccereagles.daouser.ConfirmedUserEventDao;
import pl.manes.soccereagles.inputuser.MasterUserCommand;
import pl.manes.soccereagles.structureuser.ConfirmedEvent;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class ConfirmedUserEventHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "confirm";
    private final ConfirmedUserEventDao confirmedUserEventDao;

    public ConfirmedUserEventHandler() {

        confirmedUserEventDao = new ConfirmedUserEventDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(@NotNull MasterUserCommand command) {

        switch (command.getAction()) {

            case ADD:
                log.info("A new user has been added to event");
                String confirmingName = command.getTypedCommand().get(0);
                confirmedUserEventDao.addAll(new ConfirmedEvent(confirmingName));
                break;

            case LIST:
                log.info("List of confirmed Users");
                List<ConfirmedEvent> confirmedEvent = confirmedUserEventDao.findAllConfirmedEventCategories();
                confirmedEvent.forEach(System.out::println);
                break;

            default:
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
        }
    }
}