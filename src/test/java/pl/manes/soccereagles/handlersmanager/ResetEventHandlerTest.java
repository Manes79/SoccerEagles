package pl.manes.soccereagles.handlersmanager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import static org.junit.jupiter.api.Assertions.*;

class ResetEventHandlerTest {

    @Test
    void CorrectlyCommandToResetEvent(){
        //given
        String inputData = "resetEvent reset";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("resetEvent", masterManagerCommand.getCommand());
        assertEquals(ActionManager.RESET, masterManagerCommand.getAction());
    }
}