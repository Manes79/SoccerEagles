package pl.manes.soccereagles;

import pl.manes.soccereagles.handlersManager.*;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.inputManager.MasterManagerData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SoccerEaglesManager {

    public static void main(String[] args) {

        new SoccerEaglesManager().beginManager();

    }

    private void beginManager() {

        boolean beginManager = true;

        MasterManagerData masterManagerData = new MasterManagerData();

        System.out.println("Start Soccer Eagles app");
        System.out.println("Enter the command help help for available options");
        System.out.println("Enter the command quit quit for close the app");

        List<MasterManagerHandler> managerHandlers = new ArrayList<>();
        managerHandlers.add(new HelpManagerHandler());
        managerHandlers.add(new QuitManagerHandler());
        managerHandlers.add(new EventManagerHandler());
        managerHandlers.add(new ManagerDecisionEventHandler());

        //todo
        // logging into the app

        while (beginManager) {
            try {
                MasterManagerCommand masterManagerCommand = masterManagerData.anotherCommand();
                System.out.println(masterManagerCommand);

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
                System.out.println("Quit...");
                beginManager = false;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}