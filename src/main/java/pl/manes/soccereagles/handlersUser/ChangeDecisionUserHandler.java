package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.daoUser.ChangeDecisionUserDao;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ChangeDecisionUserHandler extends BasicCommandUserHandler {

    private static final String COMMAND_NAME = "changeDecision";

    private final ChangeDecisionUserDao changeDecisionUserDao;

    public ChangeDecisionUserHandler() {

        changeDecisionUserDao = new ChangeDecisionUserDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) throws FileNotFoundException {

        switch (command.getAction()) {

            case "removeConfirmed":

                // wyświetlić listę potwierdzonych użytkowników z pliku "confirm.txt
                // następnie komenda changeDecision removeConfirmed (uzytkownik wpisany ze scannera) usuwa wybranego użytkownika
                // po wpisaniu confirmed list jest już zaktualizowana lista

                String confirmUsers = "confirm.txt";
                File fileConfirm = new File(confirmUsers);
                Scanner scannerConfirm = new Scanner(fileConfirm);
                int linesConfirm = 0;
                while (scannerConfirm.hasNextLine()) {
                    String nameConfirm = scannerConfirm.nextLine();
                    System.out.println(nameConfirm);
                    linesConfirm++;
                }
                System.out.println("Number of confirmed users " + linesConfirm);
                List<String> confirmedList = new ArrayList<>();
                for (Iterator<String> iterator = confirmedList.iterator(); iterator.hasNext(); ) {
                    String removedUser = iterator.next();
                    if (removedUser.equals(scannerConfirm)) {
                        iterator.remove();
                    }

                }

                System.out.println("The confirmed user has been removed from event");

                break;


            case "removeDeclined":
                System.out.println("The decline user has been removed from declined list");


//            case "changeConfirm":
//                String confirmUsers = "change.txt";
//                File fileConfirm = new File(confirmUsers);
//                Scanner scannerConfirm = new Scanner(fileConfirm);
//                int linesConfirm = 0;
//                while (scannerConfirm.hasNextLine()) {
//                    String nameConfirm = scannerConfirm.nextLine();
//                    System.out.println(nameConfirm);
//                    linesConfirm++;
//                    break;
//
//                }
        }
    }

    private int confirmUser() {
        return 0;
    }
}
