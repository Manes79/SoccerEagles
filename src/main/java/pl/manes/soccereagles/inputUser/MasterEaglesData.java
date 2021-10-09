package pl.manes.soccereagles.inputUser;

import java.util.Scanner;

public class MasterEaglesData {

    private final Scanner scannerUser;

    public MasterEaglesData() {

        scannerUser = new Scanner(System.in);
    }

    public MasterEaglesCommand anotherCommand() {
        return new MasterEaglesCommand(scannerUser.nextLine());
    }
}
