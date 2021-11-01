package pl.manes.soccereagles.structureuser;

import lombok.Data;

@SuppressWarnings("ALL")
@Data
public class QuestionToManager {

    private final String questionName;

    public QuestionToManager(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return questionName;
    }

    @Override
    public String toString() {
        return "QuestionToManager{" +
                "questionName='" + questionName + '\'' +
                '}';
    }
}
