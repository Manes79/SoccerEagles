package pl.manes.soccereagles.inputManager;

import pl.manes.soccereagles.ActionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterManagerCommand {

    private String command;

    private ActionManager actionManager;

    private List<String> typedCommand;

    public MasterManagerCommand(String managerLine) {

        if (managerLine != null) {
            String[] arrayManager = managerLine.split("\\s");

            if (arrayManager.length > 0) {
                command = arrayManager[0];
            }

            if (arrayManager.length > 1) {
                actionManager = ActionManager.of(arrayManager[1]);
            }

            typedCommand = new ArrayList<>();
            typedCommand.addAll(Arrays.asList(arrayManager).subList(2, arrayManager.length));
        }
    }

    public String getCommand() {
        return command;
    }

    public ActionManager getAction() {
        return actionManager;
    }

    public List<String> getTypedCommand() {
        return typedCommand;
    }

    @Override
    public String toString() {
        return "MasterManagerCommand{" +
                "command='" + command + '\'' +
                ", action='" + actionManager + '\'' +
                ", typedCommand=" + typedCommand +
                '}';
    }
}