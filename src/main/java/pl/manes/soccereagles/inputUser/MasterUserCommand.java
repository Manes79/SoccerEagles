package pl.manes.soccereagles.inputUser;

import pl.manes.soccereagles.ActionUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterUserCommand {

    private String command;

    private ActionUser action;

    private List<String> typedCommand;

    public MasterUserCommand(String userLine) {

        if (userLine != null) {
            String[] arrayUser = userLine.split("\\s");

            if (arrayUser.length > 0) {
                command = arrayUser[0];
            }

            if (arrayUser.length > 1) {
                action = ActionUser.of(arrayUser[1]);
            }

            typedCommand = new ArrayList<>();
            typedCommand.addAll(Arrays.asList(arrayUser).subList(2, arrayUser.length));

        }
    }

    public String getCommand() {
        return command;
    }

    public ActionUser getAction() {
        return action;
    }

    public List<String> getTypedCommand() {
        return typedCommand;
    }

    @Override
    public String toString() {
        return "MasterEaglesCommand{" +
                "command='" + command + '\'' +
                ", action='" + action + '\'' +
                ", typedCommand=" + typedCommand +
                '}';
    }
}
