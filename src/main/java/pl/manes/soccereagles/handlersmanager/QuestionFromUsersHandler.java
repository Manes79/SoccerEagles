package pl.manes.soccereagles.handlersmanager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class QuestionFromUsersHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "question";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException {

        if (ActionManager.FROM_USERS.equals(command.getAction())) {
            String userQuestion = "./questionToManager.txt";
            File questionFile = new File(userQuestion);
            Scanner questionScanner = new Scanner(questionFile);

            int questionLines = 0;
            while (questionScanner.hasNextLine()) {
                String questionName = questionScanner.nextLine();
                System.out.println(questionName);
                questionLines++;
            }

            questionScanner.close();

        } else {
            throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
        }
    }
}
