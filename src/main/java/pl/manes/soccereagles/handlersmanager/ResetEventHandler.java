package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class ResetEventHandler extends BasicCommandManagerHandler {

    private final static String COMMAND_NAME = "resetEvent";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException {

        if (ActionManager.RESET.equals(command.getAction())) {
            log.info("The Event has been reset");

            try {
                Files.writeString(Paths.get("./event.txt"), String.join("" + "\n"));
            } catch (IOException e) {
                log.info("Potential Warning");
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./confirm.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                log.info("Potential Warning");
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./declined.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                log.info("Potential Warning");
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./decision.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                log.info("Potential Warning");
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./information.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                log.info("Potential Warning");
                e.printStackTrace();
            }

            try {
                Files.writeString(Paths.get("./questionToManager.txt"), String.join(" " + "\n"));
            } catch (IOException e) {
                log.info("Potential Warning");
                e.printStackTrace();
            }
        }
    }
}


