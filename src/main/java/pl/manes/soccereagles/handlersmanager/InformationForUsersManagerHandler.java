package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import pl.manes.soccereagles.daomanager.InformationForUsersManagerDao;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;
import pl.manes.soccereagles.structuremanager.InformationForUser;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class InformationForUsersManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "infoForUsers";
    private final InformationForUsersManagerDao informationForUsersManagerDao;

    public InformationForUsersManagerHandler() {

        informationForUsersManagerDao = new InformationForUsersManagerDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(@NotNull MasterManagerCommand command) {

        switch (command.getAction()) {

            case ADD:
                String infoForUser = command.getTypedCommand().get(0);
                informationForUsersManagerDao.addAll(new InformationForUser(infoForUser));
                log.info("Announcement");
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

