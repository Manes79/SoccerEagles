package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EventUserStatusHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "event";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) throws FileNotFoundException {

        switch (command.getAction()) {

            case "eventStatus":
                String statusEvent = "decision.txt";
                File statusFile = new File(statusEvent);
                Scanner statusScanner = new Scanner(statusFile);

                int statusLines = 0;
                while (statusScanner.hasNextLine()) {
                    String statusName = statusScanner.nextLine();
                    System.out.println(statusName);
                    statusLines++;
                }

                statusScanner.close();
                break;
        }
    }
}
