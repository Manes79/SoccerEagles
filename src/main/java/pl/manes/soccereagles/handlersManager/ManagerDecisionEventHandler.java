package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.daoManager.ManagerDecisionEventDao;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.structureManager.ManagerDecisionEvent;

import java.util.List;

public class ManagerDecisionEventHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "decision";

    private final ManagerDecisionEventDao managerDecisionEventDao;

    public ManagerDecisionEventHandler() {

        managerDecisionEventDao = new ManagerDecisionEventDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) {

        switch (command.getAction()) {

            case "add":
                System.out.println("A new decision has been added");
                String decisionEvent = command.getTypedCommand().get(0);
                managerDecisionEventDao.addAll(new ManagerDecisionEvent(decisionEvent));
                break;

            case "list":
                System.out.println("List of decisions");
                List<ManagerDecisionEvent> managerDecisionEvent = managerDecisionEventDao.findAllManagerDecisionCategories();
                managerDecisionEvent.forEach(System.out::println);
                break;

        }
    }
}