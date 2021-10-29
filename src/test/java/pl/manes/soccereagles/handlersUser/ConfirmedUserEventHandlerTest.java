package pl.manes.soccereagles.handlersUser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConfirmedUserEventHandlerTest {

    @Test
    void CorrectCommandConfirmingTheUsersPresenceInTheEvent(){
        //given
        String inputData = "confirm add confirmingName";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("confirm", masterUserCommand.getCommand());
        assertEquals(ActionUser.ADD, masterUserCommand.getAction());
        assertEquals(List.of("confirmingName"), masterUserCommand.getTypedCommand());
    }

    @Test
    void CorrectCommandDisplayConfirmingUsersPresenceInTheEvent(){
        //given
        String inputData = "confirm list";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("confirm", masterUserCommand.getCommand());
        assertEquals(ActionUser.LIST, masterUserCommand.getAction());
    }
}