package pl.manes.soccereagles.inputuser;

import java.util.Scanner;

public class MasterUserData {

    private final Scanner scannerUser;

    public MasterUserData() {

        scannerUser = new Scanner(System.in);
    }

    public MasterUserCommand anotherCommand() {
        return new MasterUserCommand(scannerUser.nextLine());
    }
}
