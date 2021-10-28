package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InformationForUsersManagerHandlerTest {

    @Test
    void CorrectAddingInformationFromTheManagerForUsers(){
        //given
        String inputData = "infoForUsers add infoForUser";
        //then
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //when
        assertEquals("infoForUsers", masterManagerCommand.getCommand());
        assertEquals("add", masterManagerCommand.getAction());
        assertEquals(List.of("infoForUser"), masterManagerCommand.getTypedCommand());
    }

    @Test
    void CorrectDisplayingListOfInformationFromTheManagerForUsers() {
        //given
        String inputData = "infoForUsers list";
        //then
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //when
        assertEquals("infoForUsers", masterManagerCommand.getCommand());
        assertEquals("list", masterManagerCommand.getAction());
    }
}