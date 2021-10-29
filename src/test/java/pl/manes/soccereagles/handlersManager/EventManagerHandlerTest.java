package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventManagerHandlerTest {

    @Test
    void CorrectlyAddedNewEventByTheManager(){
        //given
        String inputData = "event add event";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("event", masterManagerCommand.getCommand());
        assertEquals(ActionManager.ADD, masterManagerCommand.getAction());
        assertEquals(List.of("event"), masterManagerCommand.getTypedCommand());
    }

    @Test
    void CorrectlyDisplayListOfAddedEvents(){
        //given
        String inputData = "event list";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("event", masterManagerCommand.getCommand());
        assertEquals(ActionManager.LIST, masterManagerCommand.getAction());
    }

    @Test
    void CorrectDisplayOfTheNumberOfConfirmedUsersOfTheEvent(){
        //given
        String inputData = "event statusConfirmed";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("event", masterManagerCommand.getCommand());
        assertEquals(ActionManager.STATUS_CONFIRMED, masterManagerCommand.getAction());
    }

    @Test
    void CorrectDisplayOfTheNumberOfDeclinedUsersOfTheEvent(){
        //given
        String inputData = "event statusDeclined";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("event", masterManagerCommand.getCommand());
        assertEquals(ActionManager.STATUS_DECLINED, masterManagerCommand.getAction());
    }
}