package pl.manes.soccereagles.inputmanager;

import java.util.Scanner;

public class MasterManagerData {

    private final Scanner scannerManager;

    public MasterManagerData() {

        scannerManager = new Scanner(System.in);
    }

    public MasterManagerCommand anotherCommand() {

        return new MasterManagerCommand(scannerManager.nextLine());
    }
}