package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.daomanager.EventManagerDao;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;
import pl.manes.soccereagles.structuremanager.EventManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class EventManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "event";
    private final EventManagerDao eventManagerDao;

    public EventManagerHandler() {

        eventManagerDao = new EventManagerDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException {

        switch (command.getAction()) {

            case ADD:
                log.info("A new event has been added ");
                String event = command.getTypedCommand().get(0);
                eventManagerDao.addAll(new EventManager(event));
                break;

            case LIST:
                log.info("List of events");
                List<EventManager> eventManager = eventManagerDao.findAllEventManagerCategories();
                eventManager.forEach(System.out::println);
                break;

            case STATUS_CONFIRMED:
                try {
                    String confirmUsers = "./confirm.txt";
                    File fileConfirm = new File(confirmUsers);
                    Scanner scannerConfirm = new Scanner(fileConfirm);
                    int linesConfirm = 0;
                    while (scannerConfirm.hasNextLine()) {
                        String nameConfirm = scannerConfirm.nextLine();
                        System.out.println(nameConfirm);
                        linesConfirm++;
                    }
                    log.info("Number of confirmed users " + linesConfirm);
                    break;
                } catch (IOException e) {
                    log.info("Wrong command");
                    e.printStackTrace();
                }

            case STATUS_DECLINED:
                try {
                    String declinedUsers = "./declined.txt";
                    File fileDeclined = new File(declinedUsers);
                    Scanner scannerDeclined = new Scanner(fileDeclined);
                    int linesDeclined = 0;
                    while (scannerDeclined.hasNextLine()) {
                        String nameDeclined = scannerDeclined.nextLine();
                        System.out.println(nameDeclined);
                        linesDeclined++;
                    }
                    log.info("Number of users declining an invitation to the event " + linesDeclined);
                    break;
                } catch (IOException e) {
                    log.info("Wrong command");
                    e.printStackTrace();
                }

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}