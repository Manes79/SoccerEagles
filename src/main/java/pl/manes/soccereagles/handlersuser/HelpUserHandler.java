package pl.manes.soccereagles.handlersuser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class HelpUserHandler extends BasicCommandUserHandler {

    private static final String COMMAND_NAME = "help";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(@NotNull MasterUserCommand command) {

        Object action = command.getAction();

        if (ActionUser.HELP.equals(action)) {
            System.out.println("Available commands: add, list, confirm, declined, event, eventStatus, infoFromManager announcement, questionTo");
        } else if (ActionUser.ADD.equals(action)) {
            System.out.println("Add some category");
        } else if (ActionUser.LIST.equals(action)) {
            System.out.println("Displaying confirmations and rejections of the User's decision, event status and information from Event Manager");
        } else
            throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
    }
}
