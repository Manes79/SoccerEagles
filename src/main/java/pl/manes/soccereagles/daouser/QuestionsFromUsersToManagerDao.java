package pl.manes.soccereagles.daouser;

import lombok.Data;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import pl.manes.soccereagles.structureuser.QuestionToManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
@Log
public class QuestionsFromUsersToManagerDao {

    public List<QuestionToManager> findAllQuestionToManagerCategories() {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./questionToManager.txt"));
            List<QuestionToManager> questionToManager = new ArrayList<>();
            for (String line : readAllLines) {
                questionToManager.add(new QuestionToManager(line));
            }
            return questionToManager;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addAll(@NotNull QuestionToManager questionToManager) {
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("./questionToManager.txt"));
            readAllLines.add(questionToManager.getQuestionName());

            Files.writeString(Paths.get("./questionToManager.txt"), String.join(" " + "\n", readAllLines));

        } catch (IOException e) {
            log.info("Wrong command");
            e.printStackTrace();
        }
    }
}