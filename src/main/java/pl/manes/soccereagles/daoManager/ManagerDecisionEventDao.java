package pl.manes.soccereagles.daoManager;

import pl.manes.soccereagles.structureManager.ManagerDecisionEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ManagerDecisionEventDao {

    public List<ManagerDecisionEvent> findAllManagerDecisionCategories() {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./decision.txt"));
            List<ManagerDecisionEvent> managerDecisionEvent = new ArrayList<>();
            for (String line : readAllLines) {
                managerDecisionEvent.add(new ManagerDecisionEvent(line));
            }

            return managerDecisionEvent;

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