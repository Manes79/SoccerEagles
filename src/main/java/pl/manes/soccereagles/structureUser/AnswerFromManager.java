package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class AnswerFromManager {

    private String answerName;

    public AnswerFromManager(String answerName) {
        this.answerName = answerName;
    }

    public String getAnswerName() {
        return answerName;
    }

    @Override
    public String toString() {
        return "AnswerFromManager{" +
                "answerName='" + answerName + '\'' +
                '}';
    }
}
