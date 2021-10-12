package pl.manes.soccereagles.daoUser;

import pl.manes.soccereagles.structureUser.DeclinedEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeclinedUserEventDao {

    public List<DeclinedEvent> findAllDeclinedEventCategories() {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./declined.txt"));
            List<DeclinedEvent> declinedEvents = new ArrayList<>();
            for (String line : readAllLines) {
                declinedEvents.add(new DeclinedEvent(line));
            }

            return declinedEvents;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addAll(DeclinedEvent confirmedEvent) {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./declined.txt"));
            readAllLines.add(confirmedEvent.getDeclinedName());

            Files.writeString(Paths.get("./declined.txt"), String.join(" " + "\n", readAllLines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}