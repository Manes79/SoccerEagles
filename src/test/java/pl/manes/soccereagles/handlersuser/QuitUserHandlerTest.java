package pl.manes.soccereagles.handlersuser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

import static org.junit.jupiter.api.Assertions.*;

class QuitUserHandlerTest {

    @Test
    void CorrectlyCommandToQuitSoccerEaglesUserApp(){
        //given
        String inputData = "quit quit";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("quit", masterUserCommand.getCommand());
        assertEquals(ActionUser.QUIT, masterUserCommand.getAction());
    }
}