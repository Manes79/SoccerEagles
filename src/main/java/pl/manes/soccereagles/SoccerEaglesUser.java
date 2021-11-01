package pl.manes.soccereagles;

import lombok.extern.java.Log;
import pl.manes.soccereagles.handlersuser.*;
import pl.manes.soccereagles.inputuser.MasterUserCommand;
import pl.manes.soccereagles.inputuser.MasterUserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
public class SoccerEaglesUser {

    public static void main(String[] args) {

        new SoccerEaglesUser().beginUser();
    }

    private void beginUser() {

        boolean beginUser = true;

        MasterUserData masterUserData = new MasterUserData();

        log.info("Start Soccer Eagles User app");
        log.info("Enter the command help help/add/list for available options");
        log.info("Enter the command quit quit for close the app");

        List<MasterUserHandler> userHandlers = new ArrayList<>();
        userHandlers.add(new HelpUserHandler());
        userHandlers.add(new QuitUserHandler());
        userHandlers.add(new ConfirmedUserEventHandler());
        userHandlers.add(new DeclinedUserEventHandler());
        userHandlers.add(new EventUserStatusHandler());
        userHandlers.add(new InformationForUsersHandler());
        userHandlers.add(new QuestionsFromUsersToManagerHandler());

        while (beginUser) {
            try {
                MasterUserCommand masterUserCommand = masterUserData.anotherCommand();
                log.info(String.valueOf(masterUserCommand));

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
                log.info("Quit...");
                beginUser = false;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
