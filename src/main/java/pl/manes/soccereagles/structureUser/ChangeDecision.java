package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ChangeDecision {

    private String changeDecision;

    public ChangeDecision(String changeDecision) {
        this.changeDecision = changeDecision;
    }

    public String getChangeDecision() {
        return changeDecision;
    }

    @Override
    public String toString() {
        return "ChangeDecision{" +
                "changeDecision='" + changeDecision + '\'' +
                '}';
    }
}
