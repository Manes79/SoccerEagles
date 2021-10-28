package pl.manes.soccereagles.handlersUser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

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
        assertEquals("add", masterUserCommand.getAction());
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
        assertEquals("list", masterUserCommand.getAction());
    }
}