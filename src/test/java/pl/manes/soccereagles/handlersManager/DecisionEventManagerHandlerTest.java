package pl.manes.soccereagles.handlersManager;

import org.junit.jupiter.api.Test;
import pl.manes.soccereagles.inputManager.MasterManagerCommand;

import static org.junit.jupiter.api.Assertions.*;

class DecisionEventManagerHandlerTest {

    @Test
    void WhenDecisionAboutEventItsWePlay() {
        //given
        String inputData = "decision We_Play!";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("decision", masterManagerCommand.getCommand());
        assertEquals("We_Play!", masterManagerCommand.getAction());
    }

    @Test
    void WhenDecisionAboutEventItsWeDoNotPlay() {
        //given
        String inputData = "decision We_do_not_Play!";
        //when
        MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
        //then
        assertEquals("decision", masterManagerCommand.getCommand());
        assertEquals("We_do_not_Play!", masterManagerCommand.getAction());
    }

        @Test
        void CorrectlyEnteredDataFromManagerDisplaysAListOfDecisionEvent() {
            //given
            String inputData = "decision list";
            //when
            MasterManagerCommand masterManagerCommand = new MasterManagerCommand(inputData);
            //then
            assertEquals("decision", masterManagerCommand.getCommand());
            assertEquals("list", masterManagerCommand.getAction());

        }
    }
