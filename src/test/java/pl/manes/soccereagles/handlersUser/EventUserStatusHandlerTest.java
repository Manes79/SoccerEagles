package pl.manes.soccereagles.handlersUser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

import static org.junit.jupiter.api.Assertions.*;

class EventUserStatusHandlerTest {

    @Test
    void AValidCommandToDisplayTheStatusOfTheEventToTheUser() {
        //given
        String inputData = "event eventStatus";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("event", masterUserCommand.getCommand());
        assertEquals("eventStatus", masterUserCommand.getAction());
    }

    @Test
    void AValidCommandToDisplayTheEventToTheUser(){
        //given
        String inputData = "event list";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("event", masterUserCommand.getCommand());
        assertEquals("list", masterUserCommand.getAction());
    }
}