package pl.manes.soccereagles.handlersUser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

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
        assertEquals("help", masterUserCommand.getAction());
    }
}