package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class SearchingRandomPlayerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "randomPlayer";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException, MalformedURLException {

        try {
            if (ActionManager.RANDOM_PLAYER.equals(command.getAction())) {
                URL randomUser = new URL("https://www.facebook.com/groups/450635788300121");
                log.info(randomUser.toString());

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
