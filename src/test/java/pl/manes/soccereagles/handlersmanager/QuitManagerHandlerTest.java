package pl.manes.soccereagles.handlersmanager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

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
        assertEquals(ActionManager.QUIT, masterManagerCommand.getAction());
    }
}