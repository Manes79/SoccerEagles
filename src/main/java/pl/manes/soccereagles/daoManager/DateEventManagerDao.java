package pl.manes.soccereagles.daoManager;

import pl.manes.soccereagles.structureManager.DateEventManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DateEventManagerDao {

    public List<DateEventManager> findAllDataEventManagerCategories() {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./event.txt"));
            List<DateEventManager> dateEventManagers = new ArrayList<>();
            for (String line : readAllLines) {
                dateEventManagers.add(new DateEventManager(line));
            }

            return dateEventManagers;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addAll(DateEventManager dateEventManager) {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./event.txt"));
            readAllLines.add(dateEventManager.getEventDate());

            Files.writeString(Paths.get("./event.txt"), String.join(" ", readAllLines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
