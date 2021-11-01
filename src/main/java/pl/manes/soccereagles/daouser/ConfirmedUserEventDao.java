package pl.manes.soccereagles.daouser;

import lombok.Data;
import lombok.extern.java.Log;
import pl.manes.soccereagles.structureuser.ConfirmedEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
@Log
public class ConfirmedUserEventDao {

    public List<ConfirmedEvent> findAllConfirmedEventCategories() {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./confirm.txt"));
            List<ConfirmedEvent> confirmedEvent = new ArrayList<>();
            for (String line : readAllLines) {
                confirmedEvent.add(new ConfirmedEvent(line));
            }
            return confirmedEvent;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addAll(ConfirmedEvent confirmedEvent) {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./confirm.txt"));
            readAllLines.add(confirmedEvent.getConfirmingName());

            Files.writeString(Paths.get("./confirm.txt"), String.join(" " + "\n", readAllLines));

        } catch (IOException e) {
            log.info("Potential Warning");
            e.printStackTrace();
        }
    }
}
