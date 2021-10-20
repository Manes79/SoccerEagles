package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ChangeUserEventHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "change";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) throws FileNotFoundException {

        switch (command.getAction()) {

            case "removeConfirm":
                System.out.println("The user changed his confirmatory decision");

                if ("removeConfirm".equals(command.getAction())) {
                    String confirmUsers = "confirm.txt";
                    File fileConfirm = new File(confirmUsers);
                    Scanner scannerConfirm = new Scanner(fileConfirm);
                    int linesConfirm = 0;
                    while (scannerConfirm.hasNextLine()) {
                        String nameConfirm = scannerConfirm.nextLine();
                        linesConfirm++;

                        try {
                            Files.writeString(Paths.get("./confirm.txt"), String.join(" " + "\n", nameConfirm));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
}

