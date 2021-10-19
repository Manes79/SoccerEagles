package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.daoManager.DecisionEventManagerDao;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.structureManager.ManagerDecisionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DecisionEventManagerHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "decision";

    private final DecisionEventManagerDao decisionEventManagerDao;

    public DecisionEventManagerHandler() {

        decisionEventManagerDao = new DecisionEventManagerDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException {

        if ("decision".equals(command.getAction())) {
            String confirmUsers = "confirm.txt";
            File confirmFile = new File(confirmUsers);
            Scanner scannerConfirm = new Scanner(confirmFile);
            int linesConfirm = 0;
            while (scannerConfirm.hasNextLine()) {
                String nameConfirm = scannerConfirm.nextLine();
                linesConfirm++;
            }
            if (linesConfirm >= 10)
                System.out.println("We play!");
            else
                System.out.println("We do not play!");

            scannerConfirm.close();
            System.out.println("Number of confirmed users " + linesConfirm);
        }

        switch (command.getAction()) {
            case "add":

                String decisionEvent = command.getTypedCommand().get(0);
                decisionEventManagerDao.addAll(new ManagerDecisionEvent(decisionEvent));
                System.out.println("A new event decision has been added");
                break;

            case "list":
                List<ManagerDecisionEvent> managerDecisionEvents = decisionEventManagerDao.findAllDecisionEventManagerCategories();
                managerDecisionEvents.forEach(System.out::println);
                break;

            default: {
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
            }
        }
    }
}

