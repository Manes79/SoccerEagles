package pl.manes.soccereagles.inputManager;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class MasterManagerCommandTest {

    @Test
    void CorrectlyEnteredDataFromManager() {
        //given
        String inputFromTheManager = "event add EventPlace";

        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputFromTheManager);

        //then
        assertEquals("event", masterManagerCommand.getCommand());
        assertEquals("add", masterManagerCommand.getAction());
        assertLinesMatch(List.of("EventPlace"), masterManagerCommand.getTypedCommand());

    }

//    @Test
//    void shouldBuildCorrectUserInputCommandWithMultipleParameters() {
//        //given
//        String input = "command action parameters1 parameters2 parameters3";
//
//        //when
//        UserInputCommand userInputCommand = new UserInputCommand(input);
//
//        //then
//        assertEquals("command", userInputCommand.getCommand());
//        assertEquals("action", userInputCommand.getAction());
//        assertLinesMatch(List.of("parameters1", "parameters2", "parameters3"), userInputCommand.getParameters());
//
//    }
//
//    @Test
//    void shouldBuildCorrectUserInputCommandWithoutParameters() {
//        //given
//        String input = "command action";
//
//        //when
//        UserInputCommand userInputCommand = new UserInputCommand(input);
//
//        //then
//        assertEquals("command", userInputCommand.getCommand());
//        assertEquals("action", userInputCommand.getAction());
//        assertEquals(0, userInputCommand.getParameters().size());
//
//    }

}