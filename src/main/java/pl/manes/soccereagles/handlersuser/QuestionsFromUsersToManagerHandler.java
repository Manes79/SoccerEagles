package pl.manes.soccereagles.handlersuser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import pl.manes.soccereagles.daouser.QuestionsFromUsersToManagerDao;
import pl.manes.soccereagles.inputuser.MasterUserCommand;
import pl.manes.soccereagles.structureuser.QuestionToManager;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class QuestionsFromUsersToManagerHandler extends BasicCommandUserHandler {

    private final static String COMMAND_NAME = "questionTo";
    private final QuestionsFromUsersToManagerDao questionsFromUsersToManagerDao;

    public QuestionsFromUsersToManagerHandler() {

        questionsFromUsersToManagerDao = new QuestionsFromUsersToManagerDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) {

        switch (command.getAction()) {

            case ADD:
                log.info("A new question from user to Manager");
                String questionName = command.getTypedCommand().get(0);
                questionsFromUsersToManagerDao.addAll(new QuestionToManager(questionName));
                break;

            case LIST:
                log.info("List of questions asked to the manager");
                List<QuestionToManager> questionToManager = questionsFromUsersToManagerDao.findAllQuestionToManagerCategories();
                questionToManager.forEach(System.out::println);
                break;

            default:
                throw new IllegalArgumentException((String.format("Unknown action: %s from command: %s", command.getAction(), command.getCommand())));
        }
    }
}



