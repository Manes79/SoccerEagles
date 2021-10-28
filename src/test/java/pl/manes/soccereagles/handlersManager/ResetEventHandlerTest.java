package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

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
        assertEquals("reset", masterManagerCommand.getAction());
    }
}