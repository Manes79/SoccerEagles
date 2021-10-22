package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchingUsersHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "search";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException, MalformedURLException {

        try {
            if ("randomUser".equals(command.getAction())) {
                URL randomUser = new URL("https://www.facebook.com/groups/450635788300121");
                System.out.println(randomUser.toString());

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
