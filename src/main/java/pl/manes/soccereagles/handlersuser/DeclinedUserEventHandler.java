package pl.manes.soccereagles.handlersuser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import pl.manes.soccereagles.daouser.DeclinedUserEventDao;
import pl.manes.soccereagles.inputuser.MasterUserCommand;
import pl.manes.soccereagles.structureuser.DeclinedEvent;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class DeclinedUserEventHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "declined";
    private final DeclinedUserEventDao declinedUserEventDao;

    public DeclinedUserEventHandler() {

        declinedUserEventDao = new DeclinedUserEventDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(@NotNull MasterUserCommand command) {

        switch (command.getAction()) {

            case ADD:
                log.info("The User declined the invitation to the event");
                String declinedName = command.getTypedCommand().get(0);
                declinedUserEventDao.addAll(new DeclinedEvent(declinedName));
                break;

            case LIST:
                log.info("List of users who declined an invitation to the event");
                List<DeclinedEvent> declinedEvents = declinedUserEventDao.findAllDeclinedEventCategories();
                declinedEvents.forEach(System.out::println);
                break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}