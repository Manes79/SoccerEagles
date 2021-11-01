package pl.manes.soccereagles.handlersmanager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.ActionManager;
import pl.manes.soccereagles.inputmanager.MasterManagerCommand;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DecisionEventManagerHandlerTest {

    @Test
    void CorrectlyDisplayAutomaticDecisionAboutTheEvent() {
        //given
        String inputData = "decision decision";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals(masterManagerCommand.getCommand(),"decision");
        assertEquals(masterManagerCommand.getAction(), ActionManager.DECISION);
    }

    @Test
    void WhenDecisionAboutEventItsWePlay() {
        //given
        String inputData = "decision add We_Play!";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("decision", masterManagerCommand.getCommand());
        assertEquals(ActionManager.ADD, masterManagerCommand.getAction());
        assertEquals(List.of("We_Play!"), masterManagerCommand.getTypedCommand());
    }

    @Test
    void WhenDecisionAboutEventItsWeDoNotPlay() {
        //given
        String inputData = "decision add We_do_not_Play!";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("decision", masterManagerCommand.getCommand());
        assertEquals(ActionManager.ADD, masterManagerCommand.getAction());
        assertEquals(List.of("We_do_not_Play!"), masterManagerCommand.getTypedCommand());
    }

        @Test
        void CorrectlyEnteredDataFromManagerDisplaysAListOfDecisionEvent() {
            //given
            String inputData = "decision list";
            //when
            MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
            //then
            assertEquals("decision", masterManagerCommand.getCommand());
            assertEquals(ActionManager.LIST, masterManagerCommand.getAction());

        }
    }
