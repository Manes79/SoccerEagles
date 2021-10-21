package pl.manes.soccereagles.handlersManager;

import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionFromUsersHandler extends BasicCommandManagerHandler {

    private static final String COMMAND_NAME = "question";

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionsManager(MasterManagerCommand command) throws FileNotFoundException {

        if ("fromUsers".equals(command.getAction())) {
            String userQuestion = "questionToManager.txt";
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
