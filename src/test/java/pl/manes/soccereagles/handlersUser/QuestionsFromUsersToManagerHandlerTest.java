package pl.manes.soccereagles.handlersUser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionsFromUsersToManagerHandlerTest {

    @Test
    void CorrectCommandToAddANewQuestionFromTheUserForTheManager(){
        //given
        String inputData = "questionTo add questionName";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("questionTo", masterUserCommand.getCommand());
        assertEquals(ActionUser.ADD, masterUserCommand.getAction());
        assertEquals(List.of("questionName"), masterUserCommand.getTypedCommand());
    }

    @Test
    void ValidCommandDisplayingAListOfQuestionsAskedToTheManager(){
        //given
        String inputData = "questionTo list";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("questionTo", masterUserCommand.getCommand());
        assertEquals(ActionUser.LIST, masterUserCommand.getAction());
    }
}