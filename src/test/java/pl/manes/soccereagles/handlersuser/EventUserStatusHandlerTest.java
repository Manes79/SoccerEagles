package pl.manes.soccereagles.handlersuser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

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
        assertEquals(ActionUser.EVENT_STATUS, masterUserCommand.getAction());
    }

    @Test
    void AValidCommandToDisplayTheEventToTheUser(){
        //given
        String inputData = "event list";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("event", masterUserCommand.getCommand());
        assertEquals(ActionUser.LIST, masterUserCommand.getAction());
    }
}