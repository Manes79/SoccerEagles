package pl.manes.soccereagles;

import lombok.extern.java.Log;
import pl.manes.soccereagles.handlersmanager.*;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;
import pl.manes.soccereagles.inputmanager.MasterManagerData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
public class SoccerEaglesManager {

    public static void main(String[] args) {

        new SoccerEaglesManager().beginManager();
    }

    private void beginManager() {

        boolean beginManager = true;

        MasterManagerData masterManagerData = new MasterManagerData();

        log.info("Start Soccer Eagles Manager app");
        log.info("Enter the command help help/add/list for available options");
        log.info("Enter the command quit quit for close the app");

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

        while (beginManager) {
            try {
                MasterManagerCommand masterManagerCommand = masterManagerData.anotherCommand();
                log.info(String.valueOf(masterManagerCommand));

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
                log.info("Quit...");
                beginManager = false;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}