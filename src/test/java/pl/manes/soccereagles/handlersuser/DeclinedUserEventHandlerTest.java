package pl.manes.soccereagles.handlersuser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeclinedUserEventHandlerTest {

    @Test
    void CorrectCommandRejectingThePresenceOfUsersInTheEvent(){
        //given
        String inputData = "declined add declinedName";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("declined", masterUserCommand.getCommand());
        assertEquals(ActionUser.ADD, masterUserCommand.getAction());
        assertEquals(List.of("declinedName"), masterUserCommand.getTypedCommand());
    }

    @Test
    void CorrectCommandDisplayRejectingUsersPresenceInTheEvent(){
        //given
        String inputData = "declined list";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("declined", masterUserCommand.getCommand());
        assertEquals(ActionUser.LIST, masterUserCommand.getAction());
    }
}