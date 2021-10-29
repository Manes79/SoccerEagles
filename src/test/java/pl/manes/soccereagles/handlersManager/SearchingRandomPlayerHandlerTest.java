package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import static org.junit.jupiter.api.Assertions.*;

class SearchingRandomPlayerHandlerTest {

    @Test
    void CorrectlyCommandToSearchRandomPlayer(){
        //given
        String inputData = "randomPlayer randomPlayer";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("randomPlayer", masterManagerCommand.getCommand());
        assertEquals(ActionManager.RANDOM_PLAYER, masterManagerCommand.getAction());
    }
}