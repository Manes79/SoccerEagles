package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.daomanager.DecisionEventManagerDao;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;
import pl.manes.soccereagles.structuremanager.ManagerDecisionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
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

        switch (command.getAction()) {

            case DECISION:
                String confirmUsers = "./confirm.txt";
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
                log.info("Number of confirmed users " + linesConfirm);
                break;

            case ADD:

                String decisionEvent = command.getTypedCommand().get(0);
                decisionEventManagerDao.addAll(new ManagerDecisionEvent(decisionEvent));
                log.info("A new event decision has been added");
                break;

            case LIST:
                List<ManagerDecisionEvent> managerDecisionEvents = decisionEventManagerDao.findAllDecisionEventManagerCategories();
                managerDecisionEvents.forEach(System.out::println);
                break;

        }
    }
}

