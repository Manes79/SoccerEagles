package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class ManagerQuestions {

    private final String questionName;

    public ManagerQuestions(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return questionName;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "questionName='" + questionName + '\'' +
                '}';
    }
}
