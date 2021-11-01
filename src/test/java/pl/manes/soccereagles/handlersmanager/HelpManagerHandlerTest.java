package pl.manes.soccereagles.handlersmanager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

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
        assertEquals(ActionManager.HELP, masterManagerCommand.getAction());
    }
}