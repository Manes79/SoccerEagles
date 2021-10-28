package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import static org.junit.jupiter.api.Assertions.*;

class HelpManagerHandlerTest {

    @Test
    void CorrectDisplayOfAvailableCommandsInSoccerEaglesManager(){
        //given
        String inputData = "help help";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("help", masterManagerCommand.getCommand());
        assertEquals("help", masterManagerCommand.getAction());
    }
}