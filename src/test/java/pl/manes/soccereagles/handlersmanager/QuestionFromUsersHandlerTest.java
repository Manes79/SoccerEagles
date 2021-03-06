package pl.manes.soccereagles.handlersmanager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import static org.junit.jupiter.api.Assertions.*;

class QuestionFromUsersHandlerTest {

    @Test
    void CorrectlyDisplayTheQuestionFromUsersToTheManager(){
        //given
        String inputData = "question fromUsers";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("question", masterManagerCommand.getCommand());
        assertEquals(ActionManager.FROM_USERS, masterManagerCommand.getAction());
    }
}