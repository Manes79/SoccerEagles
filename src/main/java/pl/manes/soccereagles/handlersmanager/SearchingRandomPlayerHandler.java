package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import java.net.MalformedURLException;
import java.net.URL;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class SearchingRandomPlayerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "randomPlayer";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(@NotNull MasterManagerCommand command) throws MalformedURLException {

        try {
            if (ActionManager.RANDOM_PLAYER.equals(command.getAction())) {
                URL randomUser = new URL("https://www.facebook.com/groups/450635788300121");
                log.info(randomUser.toString());

            }
        } catch (MalformedURLException e) {
            log.info("An invalid URL occurred");
            e.printStackTrace();
        }
    }
}
