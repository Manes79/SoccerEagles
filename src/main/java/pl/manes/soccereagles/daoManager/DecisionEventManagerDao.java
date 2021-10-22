package pl.manes.soccereagles.daoManager;

import pl.manes.soccereagles.structureManager.ManagerDecisionEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DecisionEventManagerDao {

    public List<ManagerDecisionEvent> findAllDecisionEventManagerCategories() {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./decision.txt"));
            List<ManagerDecisionEvent> managerDecisionEvents = new ArrayList<>();
            for (String line : readAllLines) {
                managerDecisionEvents.add(new ManagerDecisionEvent(line));
            }

            return managerDecisionEvents;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addAll(ManagerDecisionEvent managerDecisionEvent) {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./decision.txt"));
            readAllLines.add(managerDecisionEvent.getDecisionEvent());

            Files.writeString(Paths.get("./decision.txt"), String.join(" " + "\n", readAllLines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
