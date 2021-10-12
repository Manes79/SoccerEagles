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
                System.out.println("A new event has been added");
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
                File file = new File(confirmUsers);
                Scanner scanner = new Scanner(file);
                int lines = 0;
                while (scanner.hasNextLine()) {
                    String name = scanner.nextLine();
                    System.out.println(name);
                    lines++;
                }
                System.out.println("Number of confirmed users " + lines);

                scanner.close();
                break;

            case "statusDeclined":
                String declinedUsers = "declined.txt";
                File file1 = new File(declinedUsers);
                Scanner scanner1 = new Scanner(file1);
                int lines1 = 0;
                while (scanner1.hasNextLine()) {
                    String name = scanner1.nextLine();
                    System.out.println(name);
                    lines1++;
                }
                System.out.println("Number of users declining an invitation to the event " + lines1);

                scanner1.close();
                break;
        }
    }
}
