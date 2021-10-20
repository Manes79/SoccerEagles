package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InformationForUsersHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "infoFromManager";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) throws FileNotFoundException {

        if ("announcement".equals(command.getAction())) {
            String infoFromMenago = "information.txt";
            File infoFile = new File(infoFromMenago);
            Scanner infoScanner = new Scanner(infoFile);

            int infoLines = 0;
            while (infoScanner.hasNextLine()) {
                String infoName = infoScanner.nextLine();
                System.out.println(infoName);
                infoLines++;
            }

            infoScanner.close();

        }
    }
}
