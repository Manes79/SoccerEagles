package pl.manes.soccereagles.handlersuser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionUser;
import pl.manes.soccereagles.inputuser.MasterUserCommand;

import static org.junit.jupiter.api.Assertions.*;

class InformationForUsersHandlerTest {

    @Test
    void ValidCommandToDisplayTheManagerAnnouncementToTheUser(){
        //given
        String inputData = "infoFromManager announcement";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("infoFromManager", masterUserCommand.getCommand());
        assertEquals(ActionUser.ANNOUNCEMENT, masterUserCommand.getAction());
    }
}