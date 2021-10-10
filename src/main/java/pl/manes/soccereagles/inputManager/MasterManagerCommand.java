package pl.manes.soccereagles.inputManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterManagerCommand {

    private String command;

    private String action;

    private List<String> typedCommand;

    public MasterManagerCommand(String managerLine) {

        if (managerLine != null) {
            String[] arrayManager = managerLine.split("\\s");

            if (arrayManager.length > 0) {
                command = arrayManager[0];
            }

            if (arrayManager.length > 1) {
                action = arrayManager[1];
            }

            typedCommand = new ArrayList<>();
            typedCommand.addAll(Arrays.asList(arrayManager).subList(2, arrayManager.length));
        }
    }

    public String getCommand() {
        return command;
    }

    public String getAction() {
        return action;
    }

    public List<String> getTypedCommand() {
        return typedCommand;
    }

    @Override
    public String toString() {
        return "MasterManagerCommand{" +
                "command='" + command + '\'' +
                ", action='" + action + '\'' +
                ", typedCommand=" + typedCommand +
                '}';
    }
}
