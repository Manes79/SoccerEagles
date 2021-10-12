package pl.manes.soccereagles.daoManager;

import pl.manes.soccereagles.structureManager.EventManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EventManagerDao {

    public List<EventManager> findAllEventManagerCategories() {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./event.txt"));
            List<EventManager> eventManagers = new ArrayList<>();
            for (String line : readAllLines) {
                eventManagers.add(new EventManager(line));
            }

            return eventManagers;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addAll(EventManager eventManager) {
        try {

            List<String> readAllLines = Files.readAllLines(Paths.get("./event.txt"));
            readAllLines.add(eventManager.getEvent());

            Files.writeString(Paths.get("./event.txt"), String.join(" " + "\n", readAllLines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
