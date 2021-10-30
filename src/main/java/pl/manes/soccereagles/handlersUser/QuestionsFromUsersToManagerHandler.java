package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.daoUser.QuestionsFromUsersToManagerDao;
import pl.manes.soccereagles.inputUser.MasterUserCommand;
import pl.manes.soccereagles.structureUser.QuestionToManager;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

public class QuestionsFromUsersToManagerHandler extends BasicCommandUserHandler {

    private final static Logger LOG = Logger.getLogger(QuestionsFromUsersToManagerHandler.COMMAND_NAME);

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
                LOG.info("A new question from user to Manager");
                String questionName = command.getTypedCommand().get(0);
                questionsFromUsersToManagerDao.addAll(new QuestionToManager(questionName));
                break;

            case LIST:
                LOG.info("List of questions asked to the manager");
                List<QuestionToManager> questionToManager = questionsFromUsersToManagerDao.findAllQuestionToManagerCategories();
                questionToManager.forEach(System.out::println);
                break;

            default:
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
        }
    }
}



