package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.daoManager.DecisionEventManagerDao;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.structureManager.ManagerDecisionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class DecisionEventManagerHandler extends BasicCommandManagerHandler {

    private static final Logger LOG = Logger.getLogger(DecisionEventManagerHandler.COMMAND_NAME);

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
                String confirmUsers = "confirm.txt";
                File confirmFile = new File(confirmUsers);
                Scanner scannerConfirm = new Scanner(confirmFile);
                int linesConfirm = 0;
                while (scannerConfirm.hasNextLine()) {
                    String nameConfirm = scannerConfirm.nextLine();
                    linesConfirm++;
                }
                if (linesConfirm >= 10)
                    LOG.info("We play!");
                else
                    LOG.info("We do not play!");

                scannerConfirm.close();
                LOG.info("Number of confirmed users " + linesConfirm);
                break;

            case ADD:

                String decisionEvent = command.getTypedCommand().get(0);
                decisionEventManagerDao.addAll(new ManagerDecisionEvent(decisionEvent));
                LOG.info("A new event decision has been added");
                break;

            case LIST:
                List<ManagerDecisionEvent> managerDecisionEvents = decisionEventManagerDao.findAllDecisionEventManagerCategories();
                managerDecisionEvents.forEach(System.out::println);
                break;

        }
    }
}

