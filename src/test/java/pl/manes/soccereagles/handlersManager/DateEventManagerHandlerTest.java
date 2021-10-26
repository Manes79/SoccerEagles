package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateEventManagerHandlerTest {

    @Test
    void CorrectlyEnteredDataFromManagerForTheNewDateEventWithMultipleTypedCommands() {
        //given
        String inputData = "dateEvent add eventDay eventYear eventHour";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("dateEvent", masterManagerCommand.getCommand());
        assertEquals("add", masterManagerCommand.getAction());
        assertEquals(List.of("eventDay", "eventYear", "eventHour"), masterManagerCommand.getTypedCommand());
    }

    @Test
    void CorrectlyEnteredDataFromManagerDisplaysAListOfDateEvent() {
        //given
        String inputData = "dateEvent list";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("dateEvent", masterManagerCommand.getCommand());
        assertEquals("list", masterManagerCommand.getAction());

    }
}