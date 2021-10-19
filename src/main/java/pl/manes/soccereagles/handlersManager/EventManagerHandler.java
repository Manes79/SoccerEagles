package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.daoManager.EventManagerDao;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.structureManager.EventManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class EventManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "event";

    private final EventManagerDao eventManagerDao;

    public EventManagerHandler() {

        eventManagerDao = new EventManagerDao();

    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException {

        switch (command.getAction()) {

            case "add":
                System.out.println("A new event has been added ");
                String event = command.getTypedCommand().get(0);
                eventManagerDao.addAll(new EventManager(event));
                break;

            case "list":
                System.out.println("List of events");
                List<EventManager> eventManager = eventManagerDao.findAllEventManagerCategories();
                eventManager.forEach(System.out::println);
                break;

            case "statusConfirmed":
                String confirmUsers = "confirm.txt";
                File fileConfirm = new File(confirmUsers);
                Scanner scannerConfirm = new Scanner(fileConfirm);
                int linesConfirm = 0;
                while (scannerConfirm.hasNextLine()) {
                    String nameConfirm = scannerConfirm.nextLine();
                    System.out.println(nameConfirm);
                    linesConfirm++;
                }
                System.out.println("Number of confirmed users " + linesConfirm);

                scannerConfirm.close();
                break;

            case "statusDeclined":
                String declinedUsers = "declined.txt";
                File fileDeclined = new File(declinedUsers);
                Scanner scannerDeclined = new Scanner(fileDeclined);
                int linesDeclined = 0;
                while (scannerDeclined.hasNextLine()) {
                    String nameDeclined = scannerDeclined.nextLine();
                    System.out.println(nameDeclined);
                    linesDeclined++;
                }
                System.out.println("Number of users declining an invitation to the event " + linesDeclined);

                scannerDeclined.close();
                break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}
