package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.daoManager.InformationForUsersManagerDao;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.structureManager.InformationForUser;

import java.util.List;

public class InformationForUsersManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "infoForUsers";

    private final InformationForUsersManagerDao informationForUsersManagerDao;

    public InformationForUsersManagerHandler() {

        informationForUsersManagerDao = new InformationForUsersManagerDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {

        switch (command.getAction()) {

            case ADD:
                String infoForUser = command.getTypedCommand().get(0);
                informationForUsersManagerDao.addAll(new InformationForUser(infoForUser));
                System.out.println("Announcement");
                break;

            case LIST:
                List<InformationForUser> informationForUser = informationForUsersManagerDao.findAllInformationForUserManagerCategories();
                informationForUser.forEach(System.out::println);
                break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}

