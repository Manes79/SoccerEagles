package pl.manes.soccereagles;

import pl.manes.soccereagles.handlersManager.*;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.inputManager.MasterManagerData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class SoccerEaglesManager {

    public static void main(String[] args) {

        new SoccerEaglesManager().beginManager();
    }

    private static final Logger LOG = Logger.getLogger(SoccerEaglesManager.class.getName());

    private void beginManager() {

        boolean beginManager = true;

        MasterManagerData masterManagerData = new MasterManagerData();

        LOG.info("Start Soccer Eagles Manager app");
        LOG.info("Enter the command help help/add/list for available options");
        LOG.info("Enter the command quit quit for close the app");

        List<MasterManagerHandler> managerHandlers = new ArrayList<>();
        managerHandlers.add(new HelpManagerHandler());
        managerHandlers.add(new QuitManagerHandler());
        managerHandlers.add(new EventManagerHandler());
        managerHandlers.add(new DecisionEventManagerHandler());
        managerHandlers.add(new DateEventManagerHandler());
        managerHandlers.add(new InformationForUsersManagerHandler());
        managerHandlers.add(new QuestionFromUsersHandler());
        managerHandlers.add(new ResetEventHandler());
        managerHandlers.add(new SearchingRandomPlayerHandler());

        //todo
        // logging into the app

        while (beginManager) {
            try {
                MasterManagerCommand masterManagerCommand = masterManagerData.anotherCommand();
                LOG.info(String.valueOf(masterManagerCommand));

                Optional<MasterManagerHandler> timelyHandler = Optional.empty();
                for (MasterManagerHandler masterManagerHandler : managerHandlers) {
                    if (masterManagerHandler.helpInterceptionManager(masterManagerCommand.getCommand())) {
                        timelyHandler = Optional.of(masterManagerHandler);
                        break;
                    }
                }

                timelyHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + masterManagerCommand.getCommand()))
                        .interceptionsManager(masterManagerCommand);

            } catch (QuitSoccerEaglesAppException e) {
                LOG.info("Quit...");
                beginManager = false;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}