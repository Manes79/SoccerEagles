package pl.manes.soccereagles.inputManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MasterManagerCommandTest {

    @Test
    void CorrectlyEnteredDataFromTheManagerAddedTheCategory() {
        //given
        String inputData = "category add categoryName";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("category", masterManagerCommand.getCommand());
        assertEquals(ActionManager.ADD, masterManagerCommand.getAction());
        assertEquals(List.of("categoryName"), masterManagerCommand.getTypedCommand());
    }

    @Test
    void CorrectlyEnteredDataFromTheManagerDisplaysAListOfCategories() {
        //given
        String inputData = "category list";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("category", masterManagerCommand.getCommand());
        assertEquals(ActionManager.LIST, masterManagerCommand.getAction());

    }
}