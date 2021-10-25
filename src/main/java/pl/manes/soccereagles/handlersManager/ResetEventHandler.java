package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResetEventHandler extends BasicCommandManagerHandler {

    private final static String COMMAND_NAME = "resetEvent";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException {

        if ("reset".equals(command.getAction())) {
            System.out.println("The Event has been reset");

            try {
                Files.writeString(Paths.get("./event.txt"), String.join("" + "\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./confirm.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./declined.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./decision.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./information.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./questionToManager.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}


