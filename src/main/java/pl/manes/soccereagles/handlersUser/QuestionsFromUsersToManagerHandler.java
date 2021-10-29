package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.daoUser.QuestionsFromUsersToManagerDao;
import pl.manes.soccereagles.inputUser.MasterUserCommand;
import pl.manes.soccereagles.structureUser.QuestionToManager;

import java.io.FileNotFoundException;
import java.util.List;

public class QuestionsFromUsersToManagerHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "questionTo";

    private final QuestionsFromUsersToManagerDao questionsFromUsersToManagerDao;

    public QuestionsFromUsersToManagerHandler() {

        questionsFromUsersToManagerDao = new QuestionsFromUsersToManagerDao();
    }

    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) throws FileNotFoundException {

        switch (command.getAction()) {

            case ADD:
                System.out.println("A new question from user to Manager");
                String questionName = command.getTypedCommand().get(0);
                questionsFromUsersToManagerDao.addAll(new QuestionToManager(questionName));
                break;

            case LIST:
                System.out.println("List of questions asked to the manager");
                List<QuestionToManager> questionToManager = questionsFromUsersToManagerDao.findAllQuestionToManagerCategories();
                questionToManager.forEach(System.out::println);
                break;

            default:
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
        }
    }
}



