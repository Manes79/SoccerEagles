package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ManagerQuestions {

    private String questionName;

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
