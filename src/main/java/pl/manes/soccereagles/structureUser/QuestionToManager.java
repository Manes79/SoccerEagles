package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
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
