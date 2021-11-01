package pl.manes.soccereagles.handlersmanager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateEventManagerHandlerTest {

    @Test
    void CorrectlyEnteredDataFromManagerForTheNewDateEventWithMultipleTypedCommands() {
        //given
        String inputData = "dateEvent add eventDate";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("dateEvent", masterManagerCommand.getCommand());
        assertEquals(ActionManager.ADD, masterManagerCommand.getAction());
        assertEquals(List.of("eventDate"), masterManagerCommand.getTypedCommand());
    }

    @Test
    void CorrectlyEnteredDataFromManagerDisplaysAListOfDateEvent() {
        //given
        String inputData = "dateEvent list";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("dateEvent", masterManagerCommand.getCommand());
        assertEquals(ActionManager.LIST, masterManagerCommand.getAction());

    }
}