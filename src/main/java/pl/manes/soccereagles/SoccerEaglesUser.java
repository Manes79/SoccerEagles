package pl.manes.soccereagles;

import pl.manes.soccereagles.handlersUser.*;
import pl.manes.soccereagles.inputUser.MasterUserCommand;
import pl.manes.soccereagles.inputUser.MasterUserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class SoccerEaglesUser {
    public static void main(String[] args) {

        new SoccerEaglesUser().beginUser();
    }

    private static final Logger LOG = Logger.getLogger(SoccerEaglesUser.class.getName());

    private void beginUser() {

        boolean beginUser = true;

        MasterUserData masterUserData = new MasterUserData();

        LOG.info("Start Soccer Eagles User app");
        LOG.info("Enter the command help help for available options");
        LOG.info("Enter the command quit quit for close the app");

        List<MasterUserHandler> userHandlers = new ArrayList<>();
        userHandlers.add(new HelpUserHandler());
        userHandlers.add(new QuitUserHandler());
        userHandlers.add(new ConfirmedUserEventHandler());
        userHandlers.add(new DeclinedUserEventHandler());
        userHandlers.add(new EventUserStatusHandler());
        userHandlers.add(new InformationForUsersHandler());
        userHandlers.add(new QuestionsFromUsersToManagerHandler());

        //todo
        // logging into the app

        while (beginUser) {
            try {
                MasterUserCommand masterUserCommand = masterUserData.anotherCommand();
                LOG.info(String.valueOf(masterUserCommand));

                Optional<MasterUserHandler> timelyHandler = Optional.empty();
                for (MasterUserHandler masterUserHandler : userHandlers) {
                    if (masterUserHandler.helpInterceptionUser(masterUserCommand.getCommand())) {
                        timelyHandler = Optional.of(masterUserHandler);
                        break;
                    }
                }

                timelyHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + masterUserCommand.getCommand()))
                        .interceptionUser(masterUserCommand);

            } catch (QuitSoccerEaglesAppException e) {
                LOG.info("Quit...");
                beginUser = false;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
