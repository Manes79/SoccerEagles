package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

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
        assertEquals("fromUsers", masterManagerCommand.getAction());
    }
}