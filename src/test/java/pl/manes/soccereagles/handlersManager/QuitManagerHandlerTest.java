package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import static org.junit.jupiter.api.Assertions.*;

class QuitManagerHandlerTest {

    @Test
    void CorrectlyCommandToQuitSoccerEaglesManagerApp(){
        //given
        String inputData = "quit quit";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("quit", masterManagerCommand.getCommand());
        assertEquals("quit", masterManagerCommand.getAction());
    }
}