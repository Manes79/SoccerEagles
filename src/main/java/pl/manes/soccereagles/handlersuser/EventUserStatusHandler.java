package pl.manes.soccereagles.handlersuser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class EventUserStatusHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "event";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) throws FileNotFoundException {

        switch (command.getAction()) {

            case EVENT_STATUS:
                String statusEvent = "./decision.txt";
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

            case LIST:
                String listEvent = "./event.txt.";
                File listFile = new File(listEvent);
                Scanner listScanner = new Scanner(listFile);

                int listLines = 0;
                while (listScanner.hasNextLine()) {
                    String listStatus = listScanner.nextLine();
                    System.out.println(listStatus);
                    listLines++;
                }

                listScanner.close();
                break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}