package pl.manes.soccereagles.inputManager;

import org.junit.jupiter.api.Test;

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
        assertEquals("add", masterManagerCommand.getAction());
        assertEquals(List.of("categoryName"), masterManagerCommand.getTypedCommand());
    }

    @Test
    void CorrectlyEnteredDataFromManagerAddsCategoriesWithMultipleTypedCommands() {
        //given
        String inputData = "category add typedCommand1 typedCommand2 typedCommand3";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("category", masterManagerCommand.getCommand());
        assertEquals("add", masterManagerCommand.getAction());
        assertEquals(List.of("typedCommand1", "typedCommand2", "typedCommand3"), masterManagerCommand.getTypedCommand());
    }

    @Test
    void CorrectlyEnteredDataFromTheManagerDisplaysAListOfCategories() {
        //given
        String inputData = "category list";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("category", masterManagerCommand.getCommand());
        assertEquals("list", masterManagerCommand.getAction());

    }
}