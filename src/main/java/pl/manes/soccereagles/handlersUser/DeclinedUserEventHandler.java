package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.daoUser.DeclinedUserEventDao;
import pl.manes.soccereagles.inputUser.MasterUserCommand;
import pl.manes.soccereagles.structureUser.DeclinedEvent;

import java.util.List;

public class DeclinedUserEventHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "declined";

    private final DeclinedUserEventDao declinedUserEventDao;

    public DeclinedUserEventHandler() {

        declinedUserEventDao = new DeclinedUserEventDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) {

        switch (command.getAction()) {

            case "add":
                System.out.println("The User declined the invitation to the event");
                String declinedName = command.getTypedCommand().get(0);
                declinedUserEventDao.addAll(new DeclinedEvent(declinedName));
                break;

            case "list":
                System.out.println("List of users who declined an invitation to the event");
                List<DeclinedEvent> declinedEvents = declinedUserEventDao.findAllDeclinedEventCategories();
                declinedEvents.forEach(System.out::println);
                break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}