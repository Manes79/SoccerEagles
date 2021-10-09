package pl.manes.soccereagles;

import pl.manes.soccereagles.inputUser.MasterUserCommand;
import pl.manes.soccereagles.inputUser.MasterUserData;

public class SoccerEaglesUser {
    public static void main(String[] args) {

        new SoccerEaglesUser().beginUser();
    }

    private void beginUser() {

        boolean beginUser = true;

        MasterUserData masterUserData = new MasterUserData();

        System.out.println("Start Soccer Eagles app");

        //todo
        // loggin into the app

        while (beginUser) {
            try {
                MasterUserCommand masterUserCommand = masterUserData.anotherCommand();
                System.out.println(masterUserCommand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
