package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class ManagerAnswer {

    private final String answerName;

    public ManagerAnswer(String answerName) {
        this.answerName = answerName;
    }

    public String getAnswerName() {
        return answerName;
    }

    @Override
    public String toString() {
        return "ManagerAnswer{" +
                "answerName='" + answerName + '\'' +
                '}';
    }
}
