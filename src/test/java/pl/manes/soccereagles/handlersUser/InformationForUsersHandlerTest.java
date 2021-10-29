package pl.manes.soccereagles.handlersUser;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputUser.MasterUserCommand;

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
        assertEquals("announcement", masterUserCommand.getAction());
    }
}