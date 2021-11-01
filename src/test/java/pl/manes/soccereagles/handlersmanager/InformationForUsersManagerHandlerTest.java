package pl.manes.soccereagles.handlersmanager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

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
        assertEquals(ActionManager.ADD, masterManagerCommand.getAction());
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
        assertEquals(ActionManager.LIST, masterManagerCommand.getAction());
    }
}