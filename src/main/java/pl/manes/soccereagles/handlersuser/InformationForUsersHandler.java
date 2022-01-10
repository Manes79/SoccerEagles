package pl.manes.soccereagles.handlersuser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class InformationForUsersHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "infoFromManager";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(@NotNull MasterUserCommand command) {

        if (ActionUser.ANNOUNCEMENT.equals(command.getAction())) {
            try {
                String infoFromMenago = "./information.txt";
                File infoFile = new File(infoFromMenago);
                Scanner infoScanner = new Scanner(infoFile);

                int infoLines = 0;
                while (infoScanner.hasNextLine()) {
                    String infoName = infoScanner.nextLine();
                    System.out.println(infoName);
                    infoLines++;
                }
            } catch (IOException e) {
                log.info("Wrong command");
                e.printStackTrace();
            }
        }
    }
}
