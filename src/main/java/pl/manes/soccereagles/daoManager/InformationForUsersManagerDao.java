package pl.manes.soccereagles.daoManager;

import pl.manes.soccereagles.structureManager.InformationForUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    public void addAll(InformationForUser informationForUser) {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./information.txt"));
            readAllLines.add(informationForUser.getInfoForUser());

            Files.writeString(Paths.get("./information.txt"), String.join(" " + "\n", readAllLines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
