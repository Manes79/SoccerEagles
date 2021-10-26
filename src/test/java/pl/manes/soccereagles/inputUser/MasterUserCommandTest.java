package pl.manes.soccereagles.inputUser;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MasterUserCommandTest {

    @Test
    void CorrectlyEnteredDataFromUserAddedTheCategory(){
        //given
        String inputData = "category add categoryName";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("category", masterUserCommand.getCommand());
        assertEquals("add", masterUserCommand.getAction());
        assertEquals(List.of("categoryName"), masterUserCommand.getTypedCommand());
    }

    @Test
    void CorrectlyEnteredDataFromUserDisplaysAListOfCategories() {
        //given
        String inputData = "category list";
        //when
        MasterUserCommand masterUserCommand = new MasterUserCommand(inputData);
        //then
        assertEquals("category", masterUserCommand.getCommand());
        assertEquals("list", masterUserCommand.getAction());

    }
}