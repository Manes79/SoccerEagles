package pl.manes.soccereagles;

import pl.manes.soccereagles.inputUser.MasterEaglesCommand;
import pl.manes.soccereagles.inputUser.MasterEaglesData;

public class SoccerEaglesUser {
    public static void main(String[] args) {

        new SoccerEaglesUser().beginEagles();
    }

    private void beginEagles() {

        boolean beginEagles = true;

        MasterEaglesData masterEaglesData = new MasterEaglesData();

        System.out.println("Start Soccer Eagles app");

        //todo
        //logging into the app

        while (beginEagles) {
            try {
                MasterEaglesCommand masterEaglesCommand = masterEaglesData.anotherCommand();
                System.out.println(masterEaglesCommand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
