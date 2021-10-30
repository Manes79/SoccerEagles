package pl.manes.soccereagles;

import pl.manes.soccereagles.handlersUser.*;
import pl.manes.soccereagles.inputUser.MasterUserCommand;
import pl.manes.soccereagles.inputUser.MasterUserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SoccerEaglesUser {
    public static void main(String[] args) {

        new SoccerEaglesUser().beginUser();
    }

    private void beginUser() {

        boolean beginUser = true;

        MasterUserData masterUserData = new MasterUserData();

        System.out.println("Start Soccer Eagles User app");
        System.out.println("Enter the command help help for available options");
        System.out.println("Enter the command quit quit for close the app");

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
                System.out.println(masterUserCommand);

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
                System.out.println("Quit...");
                beginUser = false;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
