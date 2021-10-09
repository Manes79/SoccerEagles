package pl.manes.soccereagles;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;
import pl.manes.soccereagles.inputManager.MasterManagerData;

public class SoccerEaglesManager {
    public static void main(String[] args) {

        new SoccerEaglesManager().beginManager();

    }

    private void beginManager() {

        boolean beginManager = true;

        MasterManagerData masterManagerData = new MasterManagerData();

        System.out.println("Start Soccer Eagles app");

        //todo
        // logging into the app

        while (beginManager){
            try {
                MasterManagerCommand masterManagerCommand = masterManagerData.anotherCommand();
                System.out.println(masterManagerCommand);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}