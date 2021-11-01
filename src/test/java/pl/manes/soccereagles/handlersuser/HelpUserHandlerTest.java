package pl.manes.soccereagles.handlersuser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

import static org.junit.jupiter.api.Assertions.*;

class HelpUserHandlerTest {

    @Test
    void CorrectDisplayOfAvailableCommandsInSoccerEaglesUser(){
        //given
        String inputData = "help help";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("help", masterUserCommand.getCommand());
        assertEquals(ActionUser.HELP, masterUserCommand.getAction());
    }
}