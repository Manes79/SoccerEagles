package pl.manes.soccereagles.daomanager;

import lombok.Data;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import pl.manes.soccereagles.structuremanager.InformationForUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
@Log
public class InformationForUsersManagerDao {

    public List<InformationForUser> findAllInformationForUserManagerCategories() {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./information.txt"));
            List<InformationForUser> informationForUsers = new ArrayList<>();
            for (String line : readAllLines) {
                informationForUsers.add(new InformationForUser(line));
            }
            return informationForUsers;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addAll(@NotNull InformationForUser informationForUser) {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./information.txt"));
            readAllLines.add(informationForUser.getInfoForUser());

            Files.writeString(Paths.get("./information.txt"), String.join(" " + "\n", readAllLines));

        } catch (IOException e) {
            log.info("Wrong command");
            e.printStackTrace();
        }
    }
}
