package pl.manes.soccereagles.daoUser;

import pl.manes.soccereagles.structureUser.ChangeDecision;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ChangeDecisionUserDao {


    public void addAll(ChangeDecision changeDecision) {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./change.txt"));
            readAllLines.add(changeDecision.getChangeDecision());

            Files.writeString(Paths.get("./change.txt"), String.join("" + "/n" + readAllLines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}