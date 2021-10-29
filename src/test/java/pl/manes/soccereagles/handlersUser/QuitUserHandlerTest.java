package pl.manes.soccereagles.handlersUser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

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
        assertEquals("quit", masterUserCommand.getAction());
    }
}